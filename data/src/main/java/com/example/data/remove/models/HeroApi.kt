package com.example.data.remove.models
import android.os.Parcelable
import androidx.versionedparcelable.VersionedParcelize
import com.example.data.remove.helpers.HeroKey
import com.google.gson.annotations.SerializedName
import kotlinx.serialization.*
import kotlinx.serialization.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import java.util.logging.Level.parse
import kotlinx.parcelize.Parcelize
@Parcelize

data class HeroApi(
@SerializedName("birth_year")
val birthYear: String,
@SerializedName("eye_color")
val eyeColor: String,
@SerializedName("films")
val films: List<String>,
@SerializedName("gender")
val gender: String,
@SerializedName("hair_color")
val hairColor: String,
@SerializedName("height")
val height: String,
@SerializedName("homeworld")
val homeworld: String,
@SerializedName("mass")
val mass: String,
@SerializedName("name")
val name: String,
@SerializedName("skin_color")
val skinColor: String
) : Parcelable
{
    companion object  {
        @ImplicitReflectionSerializer
        @UnstableDefault
        fun toObject(stringValue: String): HeroApi {
            return Json.nonstrict.parse(serializer(), stringValue)
        }
    }
}
// Extension for serialization
@ImplicitReflectionSerializer
@UnstableDefault
fun HeroApi.toJson(): String {
    return Json.stringify(serializer(),this)
}