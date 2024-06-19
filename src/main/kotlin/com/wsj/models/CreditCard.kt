package com.wsj.models

import kotlinx.serialization.Serializable

@Serializable
data class CreditCard (
    val _id: String = "",
    val cardNumber: String,
    val cardHolder: String,
    val expDate: String,
    val cvv: Int
)