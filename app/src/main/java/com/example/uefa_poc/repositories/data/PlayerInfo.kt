package com.example.uefa_poc.repositories.data

import android.media.Image

data class PlayerInfo(
    var name: String,
    var position: String,
    var number: String,
    var country: String,
    // this should be image that we receive from server, but like this we will simulate image with
    // resource id and use locally prepared raw image
    var photo: Int
)
