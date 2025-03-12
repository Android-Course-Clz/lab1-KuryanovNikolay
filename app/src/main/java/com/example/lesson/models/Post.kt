package com.example.lesson.models

data class Post(
    val id: Int,
    val userId: Int,
    val content: String,
    val date: String,
    val imageResId: Int?
)
