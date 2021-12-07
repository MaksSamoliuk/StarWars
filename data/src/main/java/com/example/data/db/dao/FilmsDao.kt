package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.db.contracts.FilmSqlContract
import com.example.data.db.contracts.RoomContract

@Dao
interface FilmsDao {
    @Query("SELECT * FROM ${RoomContract.tableFilm} WHERE id = :id ")
    fun fetchFilms(id:String):List<String>
}