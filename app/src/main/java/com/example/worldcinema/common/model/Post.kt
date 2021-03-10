package com.mrz.apiwork.model
//Здесь пропиши все данные, что получишь из json
data class Post (
    val email: String,
    val password: String,
    val firstName: String,
    val lastName: String
)

data class Cover(
    val movieId: String,
    val backgroundImage: String,
    val foregroundImage: String
)