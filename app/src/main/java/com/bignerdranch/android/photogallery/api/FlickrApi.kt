package com.bignerdranch.android.photogallery.api

import retrofit2.http.GET

// Constant that stores Flickr API Key
private const val API_KEY = "b4d77265e7d08e97d47259b3d034ac7f"

// FlickrApi is a Retrofit API interface
interface FlickrApi {

    // Define a @GET HTTP request to get data from Flickr REST API's recent interesting photos
    // ~ hardcoded the URL query parameters
    @GET(
        "services/rest/?method=flickr.interestingness.getList" +
                "&api_key=$API_KEY" +
                "&format=json" +
                "&nojsoncallback=1" +
                "&extras=url_s"
    )
    suspend fun fetchPhotos(): FlickrResponse // return type is FlickrResponse, so Moshi will use our FlickrResponse class to deserialize the JSON response data

}