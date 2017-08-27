package com.ephemeris.backend

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import com.fasterxml.jackson.annotation.JsonTypeName
import java.awt.Color
import java.util.*
import kotlin.reflect.KClass

@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include= JsonTypeInfo.As.WRAPPER_OBJECT, property="type")
@JsonSubTypes({

    @JsonSubTypes.Type(value = TextCard::class, name = "text_card"),

    @JsonSubTypes.Type(value=ImageCard::class, name="cat")

})
interface Card {
    val date: Date
    val order: Long
}

enum class Theme{ Lite, Dark }
enum class LocationMode{ Place, Map }
enum class MusicMode{ Big, Small }

@JsonTypeName("text_card")
data class TextCard(val test: String, val title: String, val backgroundColor: Color, val foregroundColor: Color, override val date: Date, override val order: Long): Card
data class ImageCard(val source: String, override val date: Date, override val order: Long): Card
data class VideoCard(val source: String, override val date: Date, override val order: Long): Card
data class YoutubeCard(val id: String, override val date: Date, override val order: Long): Card
data class MusicCard(val source: String, override val date: Date, override val order: Long): Card
data class SpotifyCard(val id: String, val theme: Theme, val mode: MusicMode, override val date: Date, override val order: Long): Card
data class LocationCard(val longitude: Float, val latitude: Float, val place: String, val mode: LocationMode, override val date: Date, override val order: Long): Card
