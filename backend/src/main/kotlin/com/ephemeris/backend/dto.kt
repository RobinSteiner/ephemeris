package com.ephemeris.backend

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import org.springframework.data.annotation.Id
import java.math.BigInteger
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes(
        JsonSubTypes.Type(value = TextCard::class, name = "text_card"),
        JsonSubTypes.Type(value = ImageCard::class, name = "image_card"),
        JsonSubTypes.Type(value = VideoCard::class, name = "video_card"),
        JsonSubTypes.Type(value = YoutubeCard::class, name = "youtube_card"),
        JsonSubTypes.Type(value = MusicCard::class, name = "music_card"),
        JsonSubTypes.Type(value = SpotifyCard::class, name = "spotify_card"),
        JsonSubTypes.Type(value = LocationCard::class, name = "location_card")
)
interface Card {
    var id: BigInteger?
    val date: Date
    val order: Long
    val rows: Int
    val cols: Int
}

enum class Theme { Lite, Dark }
enum class LocationMode { Place, Map }
enum class MusicMode { Big, Small }

data class TextCard(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override var id: BigInteger? = null,
        val text: String = "",
        val title: String = "",
        val backgroundColor: String = "#ffffff",
        val foregroundColor: String = "#000000",
        override val date: Date = Date(),
        override val order: Long = 0,
        override val cols: Int = 1,
        override val rows: Int = 1) : Card

data class ImageCard(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override var id: BigInteger? = null,
        val source: String = "",
        override val date: Date = Date(),
        override val order: Long = 0,
        override val cols: Int = 1,
        override val rows: Int = 1) : Card

data class VideoCard(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override var id: BigInteger? = null,
        val source: String = "",
        override val date: Date = Date(),
        override val order: Long = 0,
        override val cols: Int = 1,
        override val rows: Int = 1) : Card

data class YoutubeCard(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override var id: BigInteger? = null,
        override val date: Date = Date(),
        override val order: Long = 0,
        override val cols: Int = 1,
        override val rows: Int = 1) : Card

data class MusicCard(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override var id: BigInteger? = null,
        val source: String = "",
        override val date: Date = Date(),
        override val order: Long = 0,
        override val cols: Int = 1,
        override val rows: Int = 1) : Card

data class SpotifyCard(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override var id: BigInteger? = null,
        val theme: Theme = Theme.Lite,
        val mode: MusicMode = MusicMode.Small,
        override val date: Date = Date(),
        override val order: Long = 0,
        override val cols: Int = 1,
        override val rows: Int = 1) : Card

data class LocationCard(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) override var id: BigInteger? = null,
        val longitude: Float = 0F,
        val latitude: Float = 0F,
        val place: String = "",
        val mode: LocationMode = LocationMode.Map,
        override val date: Date = Date(),
        override val order: Long = 0,
        override val cols: Int = 1,
        override val rows: Int = 1) : Card
