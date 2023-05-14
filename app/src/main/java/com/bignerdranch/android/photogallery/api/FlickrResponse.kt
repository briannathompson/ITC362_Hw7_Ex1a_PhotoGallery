package com.bignerdranch.android.photogallery.api

import com.squareup.moshi.JsonClass

// FlickrResponse purpose: This class will map to the outermost object in the JSON data
//  the one that's at the top of the JSON object hierarchy, denoted by the outermost { }
@JsonClass(generateAdapter = true)
data class FlickrResponse(
    val photos: PhotoResponse       // property to map to "photos" field
)
