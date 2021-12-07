package com.example.data.remove.services

import com.example.data.remove.models.HeroApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Url

interface HeroesService {

@GET("people/?page/")
    fun getHeroes():Deferred<List<HeroApi>>




}