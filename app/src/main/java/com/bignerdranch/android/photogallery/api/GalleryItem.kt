package com.bignerdranch.android.photogallery.api

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GalleryItem(
    val title: String,
    val id: String,
    @Json(name = "url_s")val url: String,   // @Json tells Moshi which JSON object to map to our url property
)
/* NOTE:
*   @JsonClass annotation tells Moshi to perform its code generation work during compilation,
*       which will generate the code to adapt the JSON string into a GalleryItem
*/

