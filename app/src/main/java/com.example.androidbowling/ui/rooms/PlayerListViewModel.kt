package com.example.androidbowling.ui.rooms

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerListViewModel(application: Application) : ViewModel() {
    private val db = RoomSingleton.getInstance(application)

    internal val playerList: LiveData<MutableList<PlayerList>> = db.playerListDao().getTodos()

    fun insert(todo: PlayerList) {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().insert(todo)
        }
    }

    fun update(todo: PlayerList) {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().update(todo)
        }
    }

    fun delete(todo: PlayerList) {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().delete(todo)
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().clear()
        }
    }

}