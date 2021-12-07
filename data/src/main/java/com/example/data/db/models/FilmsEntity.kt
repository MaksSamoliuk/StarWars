package com.example.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.db.contracts.RoomContract

@Entity(tableName = RoomContract.tableFilm)
data class FilmsEntity(@PrimaryKey val id: String, val title :String,val episode_id :Int,val opening_crawl : String,
                       val director: String,val url: String)