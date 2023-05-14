package com.bignerdranch.android.photogallery.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

// PhotoResponse purpose: Used to map the "photos" object in the JSON data
@JsonClass(generateAdapter = true)
data class PhotoResponse(
    @Json(name = "photo") val galleryItems: List<GalleryItem>       // anything that matches the tag will get piped into GalleryItem
)
