package com.example.androidbowling.ui.rooms

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayerListViewModel(application: Application) : ViewModel() {
    private val db = RoomSingleton.getInstance(application)

    internal val playerListList: LiveData<MutableList<Player>> =
        db.playerListDao().getPlayerlists()

    fun insert(playerlist: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().insert(playerlist)
        }
    }

    fun update(playerlist: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().update(playerlist)
        }
    }

    fun delete(playerlist: Player) {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().delete(playerlist)
        }
    }

    fun clear() {
        viewModelScope.launch(Dispatchers.IO) {
            db.playerListDao().clear()
        }
    }

}