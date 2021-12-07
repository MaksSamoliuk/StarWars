package com.example.amazingapp_starwars.views
import com.example.domain.models.Hero
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(value = AddToEndSingleStrategy:: class)
interface HeroListView: MvpView {
    fun presentHeroes(data:List<Hero>)
    fun presentLoading()

}