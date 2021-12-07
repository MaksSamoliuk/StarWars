package com.example.data.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.db.contracts.RoomContract
import com.example.data.db.dao.FilmsDao
import com.example.data.db.dao.HeroDao
import com.example.data.db.models.FilmsEntity
import com.example.data.db.models.HeroEntity

@Database(entities = [FilmsEntity::class,HeroEntity::class],version = 1)
public abstract class RoomAppDataBase: RoomDatabase(){
    abstract fun heroDao():HeroDao
    abstract fun FilmsDao():FilmsDao

    companion object{
        fun buildDataSourse(context: Context):RoomDatabase = Room.databaseBuilder(context,RoomAppDataBase::class.java,
        RoomContract.dataBaseApp)
            .build() }

}