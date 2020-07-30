package com.tonykalo.githubapp.ui.search_fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tonykalo.githubapp.R
import com.tonykalo.githubapp.ui.search_fragment.data.network.pojo.Item
import de.hdodenhof.circleimageview.CircleImageView
import javax.inject.Inject
import kotlinx.android.synthetic.main.row_github_repo.view.*

class GithubReposAdapter @Inject constructor(private val context: Context) : RecyclerView.Adapter<GithubReposAdapter.GithubReposViewHolder>() {

    private var repoList: List<Item> = emptyList()
    var onClickListener: OnRepoClickListener? = null

    fun setData(repoList: List<Item>) {
        this.repoList = repoList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubReposViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.row_github_repo, parent, false)
        return GithubReposViewHolder(view)
    }

    override fun getItemCount(): Int {
        return repoList.size
    }

    override fun onBindViewHolder(holder: GithubReposViewHolder, position: Int) {
        holder.apply {
            repoList[position].apply {
                tvUsername.text = owner.login
                tvRepoName.text = name
                tvWatchers.text = watchers_count.toString()
                tvForks.text = forks.toString()
                tvIssues.text = open_issues_count.toString()
                Glide.with(context).asBitmap().load(owner.avatar_url).placeholder(R.drawable.github_logo).into(civUserImage)
                civUserImage.setOnClickListener { onClickListener?.onUserClick(owner.url) }
                viewHolder.setOnClickListener { onClickListener?.onRepoClick(url) }
            }
        }
    }

    class GithubReposViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val civUserImage: CircleImageView = itemView.civUser
        val tvUsername: TextView = itemView.tvUsername
        val tvRepoName: TextView = itemView.tvRepo
        val tvWatchers: TextView = itemView.tvWatchers
        val tvForks: TextView = itemView.tvForks
        val tvIssues: TextView = itemView.tvIssues
        val viewHolder: ConstraintLayout = itemView.clMainHolder
    }
}
