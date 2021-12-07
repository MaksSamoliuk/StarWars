package com.example.domain.converters
import com.example.data.remove.models.HeroApi
import com.example.domain.models.Hero

class HeroConverterImpl {

    fun fromApitoUI(model:HeroApi): Hero {
        return Hero(
            id = model.birthYear,
            title = model.name,
            Gender = if (model.gender == "Melee") {
                0
            } else {
                1
            },
            icon = "")

    }



}