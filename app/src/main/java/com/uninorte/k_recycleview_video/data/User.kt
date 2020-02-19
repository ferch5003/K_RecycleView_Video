package com.uninorte.k_recycleview_video.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User (
    val title: String,
    val first: String,
    val last: String,
    val email: String,
    val phone: String,
    val img: String
    ): Parcelable {

}