package com.example.domain.repositories.implementations

import com.example.data.db.RoomAppDataBase
import com.example.data.remove.providers.HeroProviderImpl
import com.example.domain.converters.HeroConverterImpl
import com.example.domain.models.Hero
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import java.lang.Exception

class HeroRepositoryImpl( private val heroConverter: HeroConverterImpl ) {
    private val heroProvider: HeroProviderImpl = HeroProviderImpl()
    @DelicateCoroutinesApi
    suspend fun fetchHeroes():Deferred<List<Hero>>{
      return try {
         val heroes = heroProvider.getHeroesList().await()
           GlobalScope.async {
              heroes.map {
                      hero ->heroConverter.fromApitoUI(model = hero) }
          }
      }
      catch (e:Exception){
           GlobalScope.async { error(e) }
      }
    }
}