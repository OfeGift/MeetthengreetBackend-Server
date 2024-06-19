package com.wsj.models

import kotlinx.serialization.Serializable

@Serializable
data class GiftCard (
    val _id: String = "",
    val email: String,
    val imageFrontUrl: String,
    val imageBackUrl: String
)