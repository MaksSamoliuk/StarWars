package com.example.amazingapp_starwars.presenters
import android.system.Os.remove
import com.example.domain.models.Hero
import com.example.amazingapp_starwars.views.HeroListView
import com.example.domain.converters.HeroConverterImpl
import com.example.domain.repositories.implementations.HeroRepositoryImpl
import kotlinx.coroutines.*
import moxy.InjectViewState
import moxy.MvpPresenter
import kotlin.Exception

@InjectViewState
class HeroListPresenter: MvpPresenter<HeroListView>() {
private val heroesRepositoryImpl = HeroRepositoryImpl(heroConverter = HeroConverterImpl())
         @DelicateCoroutinesApi
         suspend fun fetchHeroes() {

        viewState.presentLoading()
        GlobalScope.launch() { Dispatchers.IO }
           try {
               val heroes = heroesRepositoryImpl.fetchHeroes().await()
               withContext(Dispatchers.Main){
                   viewState.presentHeroes(data = heroes)
               }
           }
           catch (e:Exception){
               e.printStackTrace()
           }
        }
    }


