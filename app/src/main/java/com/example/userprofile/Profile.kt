package com.example.userprofile

import android.net.Uri
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Profile(
    val firstName: String,
    val lastName: String,
    val discription: String,
    val Uri: Uri?
) : Parcelable {

}