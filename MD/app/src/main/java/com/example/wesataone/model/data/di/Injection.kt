package com.example.wesataone.model.data.di

import android.content.Context
import com.example.wesataone.model.data.Repository
import com.example.wesataone.model.data.local.datastore.Preferences
import com.example.wesataone.model.data.local.datastore.dataStore
import com.example.wesataone.model.data.remote.ApiConfig
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context: Context): Repository{
        val pref = Preferences.getInstance(context.dataStore)
        val user = runBlocking { pref.getSession().first() }
        val apiService = ApiConfig.getApiService(user.token)
        return Repository.getInstance(apiService, pref)
    }
}