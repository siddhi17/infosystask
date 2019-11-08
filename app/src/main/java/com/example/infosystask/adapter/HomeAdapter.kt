package com.example.infosystask.adapter

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.signature.ObjectKey
import com.example.infosystask.model.Row
import com.example.infosystask.viewholder.HomeViewHolder
import com.nostra13.universalimageloader.core.ImageLoader
import android.graphics.Bitmap
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener
import android.view.View
import com.bumptech.glide.Priority
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.infosystask.R
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration


class HomeAdapter(var factRowList: List<Row>, var onClickCall: ClickableRow)
    : androidx.recyclerview.widget.RecyclerView.Adapter<HomeViewHolder>() {

    companion object {
        private const val TYPE_ROW = 0
    }

    override fun onBindViewHolder(viewHolder: HomeViewHolder, position: Int) {

        if (getItemViewType(position) == TYPE_ROW) {
            showDirectoryList(viewHolder, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {

        var viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder
        val inflater = parent.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        viewHolder = when (viewType) {

            TYPE_ROW -> {
                val viewEvent = inflater.inflate(R.layout.layout_facts_row, parent, false)
                HomeViewHolder(viewEvent)
            }

            else -> {
                val view = inflater.inflate(R.layout.layout_facts_row, parent, false)
                HomeViewHolder(view)
            }
        }

        return viewHolder
    }

    override fun getItemCount(): Int {
        return factRowList.size
    }

    override fun getItemViewType(position: Int): Int {
        return TYPE_ROW
    }

    private fun showDirectoryList(viewHolder: HomeViewHolder, position: Int) {

        var data = factRowList[position]

        viewHolder.tvName.text = data.title 
        viewHolder.tvStore.text = data.description

     /*   Glide.with(viewHolder.itemView.context)
                .load(data.imageHref)
                .thumbnail(0.5f)

                .into(viewHolder.imgCard)*/

 /*       Glide.with(viewHolder.itemView.context)
            .load(data.imageHref.toString())
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.mipmap.ic_launcher_round)
            .dontAnimate()
            .fallback(R.drawable.ic_launcher_background)
            .into(viewHolder.imgCard)*/

  /*      Glide.with(viewHolder.itemView.context)
            .load(data.imageHref)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.mipmap.ic_launcher_round)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
            .into(viewHolder.imgCard);*/
/*


        Picasso.get()
            .load(myUri)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.mipmap.ic_launcher_round)
            .into(viewHolder.imgCard)*/


     val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .override(100, 100) // resize does not respect aspect ratio

        Glide.with(viewHolder.itemView.context)
            .load(data.imageHref)
            .transition(DrawableTransitionOptions.withCrossFade())
            .error(R.mipmap.ic_launcher_round)
            .into(viewHolder.imgCard)



        viewHolder.itemView.setOnClickListener {
            onClickCall.onClickRow(factRowList[position]) }
    }

}

interface ClickableRow{
    fun onClickRow(item : Row)
}