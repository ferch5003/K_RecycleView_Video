package com.uninorte.k_recycleview_video.databinding;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.uninorte.k_recycleview_video.R;

public class GlideBinding {

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView view, int imageUrl){
        Context context = view.getContext();

        RequestOptions option = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(option)
                .load(imageUrl)
                .into(view);
    }

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView view, String imageUri){
        Context context = view.getContext();

        RequestOptions option = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(option)
                .load(imageUri)
                .into(view);
    }

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView view, Uri imageUri){
        Context context = view.getContext();

        RequestOptions option = new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background);

        Glide.with(context)
                .setDefaultRequestOptions(option)
                .load(imageUri)
                .into(view);
    }
}
