package com.example.data.remove.helpers

import com.example.data.remove.models.HeroApi
import com.google.gson.annotations.SerializedName

enum class HeroKey(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<HeroApi>
)