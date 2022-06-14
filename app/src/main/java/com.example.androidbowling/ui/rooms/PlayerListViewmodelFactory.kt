package com.example.androidbowling.ui.rooms

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PlayerListViewmodelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayerListViewModel::class.java)) {
            return PlayerListViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}