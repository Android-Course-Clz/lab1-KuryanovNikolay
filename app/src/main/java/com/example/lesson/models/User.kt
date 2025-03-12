package com.example.lesson.models

data class User(
    val id: Int,
    val name: String,
    val avatarUrl: String,
    val status: String,
    val age: Int,
    val friendsCount: Int,
    val city: String,
)
