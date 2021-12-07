package com.example.data.remove.models
import com.google.gson.annotations.SerializedName
data class FilmApi (
    @SerializedName("opening_crawl")
val openingCrawl: String,
    @SerializedName("title")
    val title: String
)


