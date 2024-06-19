package com.wsj.models

import kotlinx.serialization.Serializable

@Serializable
data class CryptoCurrency (
    val _id: String = "",
    val email: String,
    val imageUrl: String
)