package com.bignerdranch.android.photogallery.api

import com.squareup.moshi.JsonClass

// FlickrResponse purpose: This class will map to the outermost object in the JSON data
@JsonClass(generateAdapter = true)
data class FlickrResponse(
    val photos: PhotoResponse   // property to map to "photos" field, don't need @Json bc the names match
)
