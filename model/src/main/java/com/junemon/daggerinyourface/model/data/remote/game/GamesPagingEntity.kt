package com.junemon.daggerinyourface.model.data.remote.game

import com.google.gson.annotations.SerializedName

data class ShortScreenshotsItemPagingEntity(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("id")
    val id: Int = 0
)

data class PlatformPagingEntity(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("slug")
    val slug: String = ""
)

data class PlatformsItemPagingEntity(
    @SerializedName("requirements_en")
    val requirementsEn: RequirementsEnPaging,
    @SerializedName("released_at")
    val releasedAt: String = "",
    @SerializedName("platform")
    val platform: PlatformPagingEntity
)

data class StorePagingEntity(
    @SerializedName("games_count")
    val gamesCount: Int = 0,
    @SerializedName("domain")
    val domain: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_background")
    val imageBackground: String = "",
    @SerializedName("slug")
    val slug: String = ""
)

data class StoresItemPagingEntity(
    @SerializedName("url_ru")
    val urlRu: String = "",
    @SerializedName("url_en")
    val urlEn: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("store")
    val store: StoreEntity
)

data class AddedByStatusPagingEntity(
    @SerializedName("owned")
    val owned: Int = 0,
    @SerializedName("beaten")
    val beaten: Int = 0,
    @SerializedName("dropped")
    val dropped: Int = 0,
    @SerializedName("yet")
    val yet: Int = 0,
    @SerializedName("playing")
    val playing: Int = 0,
    @SerializedName("toplay")
    val toplay: Int = 0
)

data class ClipPagingEntity(
    @SerializedName("preview")
    val preview: String = "",
    @SerializedName("clip")
    val clip: String = ""
)

data class RatingsItemPagingEntity(
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("percent")
    val percent: Double = 0.0
)

data class GenresItemPagingEntity(
    @SerializedName("games_count")
    val gamesCount: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image_background")
    val imageBackground: String = "",
    @SerializedName("slug")
    val slug: String = ""
)

data class GamesPagingEntity(
    @SerializedName("added")
    val added: Int = 0,
    @SerializedName("rating")
    val rating: Double = 0.0,
    @SerializedName("metacritic")
    val metacritic: Int = 0,
    @SerializedName("playtime")
    val playtime: Int = 0,
    @SerializedName("short_screenshots")
    val shortScreenshots: List<ShortScreenshotsItemPagingEntity>?,
    @SerializedName("platforms")
    val platforms: List<PlatformsItemPagingEntity>?,
    @SerializedName("rating_top")
    val ratingTop: Int = 0,
    @SerializedName("reviews_text_count")
    val reviewsTextCount: Int = 0,
    @SerializedName("ratings")
    val ratings: List<RatingsItemEntity>?,
    @SerializedName("genres")
    val genres: List<GenresItemEntity>?,
    @SerializedName("saturated_color")
    val saturatedColor: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("added_by_status")
    val addedByStatus: AddedByStatusEntity,
    @SerializedName("parent_platforms")
    val parentPlatforms: List<ParentPlatformsItemPaging>?,
    @SerializedName("ratings_count")
    val ratingsCount: Int = 0,
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("released")
    val released: String = "",
    @SerializedName("suggestions_count")
    val suggestionsCount: Int = 0,
    @SerializedName("stores")
    val stores: List<StoresItemEntity>?,
    @SerializedName("background_image")
    val backgroundImage: String = "",
    @SerializedName("tba")
    val tba: Boolean = false,
    @SerializedName("dominant_color")
    val dominantColor: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("clip")
    val clip: ClipEntity,
    @SerializedName("reviews_count")
    val reviewsCount: Int = 0
)

data class RequirementsEnPaging(
    @SerializedName("minimum")
    val minimum: String = "",
    @SerializedName("recommended")
    val recommended: String = ""
)

data class ParentPlatformsItemPaging(
    @SerializedName("platform")
    val platform: PlatformEntity
)