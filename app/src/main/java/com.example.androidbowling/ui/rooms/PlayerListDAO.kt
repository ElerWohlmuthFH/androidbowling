package com.example.androidbowling.ui.rooms

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlayerListDAO {
    @Query("SELECT * FROM todoTBL ORDER BY id DESC")
    fun getPlayerlists(): LiveData<MutableList<PlayerList>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playerlist: PlayerList)

    @Update
    suspend fun update(playerlist: PlayerList)

    @Delete
    suspend fun delete(playerlist: PlayerList)

    @Query("DELETE FROM todoTBL")
    suspend fun clear()
}