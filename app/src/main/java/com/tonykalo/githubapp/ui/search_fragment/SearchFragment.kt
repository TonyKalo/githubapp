package com.tonykalo.githubapp.ui.search_fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.tonykalo.githubapp.R
import com.tonykalo.githubapp.ui.search_fragment.adapter.GithubReposAdapter
import com.tonykalo.githubapp.ui.search_fragment.adapter.OnRepoClickListener
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Owner
import com.tonykalo.githubapp.utils.extensions.makeGone
import com.tonykalo.githubapp.utils.extensions.makeVisible
import dagger.android.support.DaggerFragment
import javax.inject.Inject
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : DaggerFragment(), OnRepoClickListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var adapter: GithubReposAdapter

    private val mViewModel by viewModels<SearchViewModel> { viewModelFactory }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickListeners()
        setQueryListener()
        setObservers()
        initAll()
    }

    private fun initAll() {
        initAdapter()
        srlSearch.setOnRefreshListener { mViewModel.onQueryTxtChange(svSearch.query.toString()) }
    }
    private fun initAdapter() {
        rvRepos.layoutManager = LinearLayoutManager(context)
        rvRepos.adapter = adapter
        adapter.onClickListener = this
    }

    private fun setQueryListener() {
        svSearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {
                return true
            }

            override fun onQueryTextChange(p0: String): Boolean {
                mViewModel.onQueryTxtChange(p0)
                showNoRepoFound(p0.isEmpty())
                return true
            }
        })
    }

    private fun setObservers() {
        mViewModel.openSortDialog.observe(viewLifecycleOwner, Observer { if (it != -1) openSortDialog(it) })
        mViewModel.handleError.observe(viewLifecycleOwner, Observer { showSnackbar(it) })
        mViewModel.githubRepos.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
            showNoRepoFound(it.isNullOrEmpty())
        })
        mViewModel.showLoader.observe(viewLifecycleOwner, Observer { showSwipeLoader(it) })
    }

    private fun setOnClickListeners() {
        ivSort.setOnClickListener { mViewModel.onSortClick() }
    }

    private fun openSortDialog(selectedChoice: Int) {
        val sortByList = resources.getStringArray(R.array.sort_by)
        AlertDialog.Builder(requireContext())
            .setTitle(getString(R.string.title_sort_by))
            .setSingleChoiceItems(sortByList, selectedChoice) { dialog, which ->
                mViewModel.onSelectedChoice(which)
                mViewModel.onQueryTxtChange(svSearch.query.toString())
                dialog.dismiss()
            }
            .setOnDismissListener { mViewModel.onDialogDismiss() }
            .show()
    }

    private fun showSwipeLoader(show: Boolean) {
        srlSearch.isRefreshing = show
    }

    private fun showSnackbar(msg: String) {
        Snackbar.make(requireActivity().findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG).show()
    }

    private fun showNoRepoFound(show: Boolean) {
        if (show) tvNoReposFound.makeVisible() else tvNoReposFound.makeGone() }

    override fun onUserClick(owner: Owner) {
        findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToUserDetailFragment(owner))
    }

    override fun onRepoClick(repo: Item) {
        findNavController().navigate(SearchFragmentDirections.actionSearchFragmentToRepoDetailFragment(repo))
    }
}
