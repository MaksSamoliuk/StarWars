package com.example.domain.converters

import com.example.data.db.models.HeroEntity
import com.example.data.remove.models.FilmApi
import com.example.data.remove.models.HeroApi
import com.example.domain.models.Hero

interface HeroConverter {
    fun convertFromApiToDomain(heroApi: HeroApi,FilmApi:FilmApi):Hero
    fun convertFromApiToDb(heroApi: HeroApi,FilmApi: FilmApi):HeroEntity

}