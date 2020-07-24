package com.tonykalo.githubapp.core.di.module

import android.app.Application
import android.content.Context
import com.tonykalo.githubapp.GithubApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Provides
    @JvmStatic
    @Singleton
    fun provideApplication(app: GithubApp): Application = app

    @Provides
    @Singleton
    fun provideAppContext(app: Application): Context {
        return app.applicationContext
    }
}
