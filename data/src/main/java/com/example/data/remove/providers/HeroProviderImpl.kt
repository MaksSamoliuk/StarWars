package com.example.data.remove.providers
import com.example.data.remove.helpers.RetorfitFactory
import com.example.data.remove.models.HeroApi
import kotlinx.coroutines.Deferred
import kotlinx.serialization.UnstableDefault
import retrofit2.Retrofit

class HeroProviderImpl {
 @UnstableDefault
 fun getHeroesList():Deferred<List<HeroApi>>
 {
     return RetorfitFactory.getHeroesService().getHeroes()
 }

}