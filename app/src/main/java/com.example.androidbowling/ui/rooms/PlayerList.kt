package com.example.androidbowling.ui.rooms

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTBL")
class PlayerList(
    @PrimaryKey
    var id: Long?,

    @ColumnInfo(name = "uuid")
    var fullName: String,

    @ColumnInfo(name = "notes")
    var notes: String
) {

}