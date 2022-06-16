package com.example.androidbowling.ui.rooms

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PlayerListDAO {
    @Query("SELECT * FROM todoTBL ORDER BY id DESC")
    fun getPlayerlists(): LiveData<MutableList<Player>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playerlist: Player)

    @Update
    suspend fun update(playerlist: Player)

    @Delete
    suspend fun delete(playerlist: Player)

    @Query("DELETE FROM todoTBL")
    suspend fun clear()
}