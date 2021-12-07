package com.example.data.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.data.db.contracts.RoomContract

@Entity(tableName = RoomContract.tableHero)
data class HeroEntity(@PrimaryKey val id : String, val displayName : String, val avatar : String, val gender : String ) {
}