package com.bignerdranch.android.photogallery

import com.bignerdranch.android.photogallery.api.FlickrApi
import com.bignerdranch.android.photogallery.api.GalleryItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create


// This class was created so the the Retrofit configuration code and API interface instantiation
//      would be separate from the fragment
class PhotoRepository {
    // !! Add a property to stash a FlickrApi instance:
    // ~ flickrApi declaration:
    private val flickrApi: FlickrApi
    // ~ flickerApi assignment:
    init {
        // ~ Build instance of Retrofit:
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")     // ~ Base URL for the endpoint, we're using Flickr's base API
            .addConverterFactory(MoshiConverterFactory.create())    // ~ Moshi converter for Retrofit object
            .build()    // ~ this .build() call returns a Retrofit instance
        // ~ Creating an instance of our API interface FlickrApi using retrofit (our instance of Retrofit)
        flickrApi = retrofit.create()
    }

    // !! Add the fetchPhotos() function and call through to the fetchPhotos() function in FlickrApi (our API interface)
    //      and use it to return the list of gallery items
    suspend fun fetchPhotos(): List<GalleryItem> = flickrApi.fetchPhotos().photos.galleryItems
}
