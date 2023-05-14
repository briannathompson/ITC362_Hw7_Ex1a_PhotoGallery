package com.bignerdranch.android.photogallery

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bignerdranch.android.photogallery.api.GalleryItem
import com.bignerdranch.android.photogallery.databinding.ListItemGalleryBinding

/*  Extend these RecyclerView classes:
*       1. RecyclerView.ViewHolder      -->     PhotoViewHolder
*       2. RecyclerView.Adapter         -->     PhotoListAdapter
*/

//  PhotoViewHolder extends RecyclerView.ViewHolder
//  It is responsible for holding onto an instance of the view for the list_item_gallery layout
//      and binding a GalleryItem to that view
class PhotoViewHolder(
    private val binding: ListItemGalleryBinding // constructor parameter
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(galleryItem: GalleryItem) {    // this function with update PhotoViewHolder with the data from a GalleryItem
        // !! Call the load() extension function that Coil provides for the ImageView (ours is itemImageView)
        //      and pass in the url property from the GalleryItem
        binding.itemImageView.load(galleryItem.url) {
            // !! Use bill_up_close.png as a placeholder while images download from Flickr
            placeholder(R.drawable.bill_up_close)
        }
    }
}

//  PhotoListAdapter extends RecyclerView.Adapter
//  It will manage the communication between the RecyclerView and the backing data,
//      providing PhotoViewHolder instances to the RecyclerView and
//      binding those instances with a GalleryItem at the correct position
class PhotoListAdapter(     // will provide PhotoViewHolders as needed, based on a list of GalleryItems
    private val galleryItems: List<GalleryItem>
) : RecyclerView.Adapter<PhotoViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PhotoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemGalleryBinding.inflate(inflater, parent, false)
        return PhotoViewHolder(binding)
    }
    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val item = galleryItems[position]
        holder.bind(item)
    }
    override fun getItemCount() = galleryItems.size
}
