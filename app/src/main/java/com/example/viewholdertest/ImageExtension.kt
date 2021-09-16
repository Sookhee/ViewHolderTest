package com.example.viewholdertest

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ImageExtension {
    @JvmStatic
    @BindingAdapter("image")
    fun setImageView(imageView: ImageView, imageUrl: String) {
        Glide
            .with(imageView.context)
            .load(imageUrl)
            .centerCrop()
            .into(imageView)

        imageView.alpha = 0.2f
    }
}
