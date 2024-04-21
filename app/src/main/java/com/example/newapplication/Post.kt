package com.example.newapplication

import java.io.Serializable

data class Post(
    var name: String,
    var id: Int,
    var userName: String,
    var profilePhoto: Int,
    var likeSize: Int,
    var postPhoto: Int
) : Serializable
