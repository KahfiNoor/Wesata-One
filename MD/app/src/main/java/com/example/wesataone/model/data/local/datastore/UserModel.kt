package com.example.wesataone.model.data.local.datastore

data class UserModel(
    val token: String,
    val email: String,
    val password: String,
    val isLogin: Boolean = false
)
