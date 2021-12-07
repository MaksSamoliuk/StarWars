package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.db.contracts.HeroSqlContract
import com.example.data.db.models.HeroEntity

@Dao
interface HeroDao {
    @Query(HeroSqlContract.fetch)
    fun fetchHeroes(): List<HeroEntity>
    @Insert(entity = HeroEntity::class,onConflict = OnConflictStrategy.REPLACE)
    fun snsertHero(heroEntity: HeroEntity)
}