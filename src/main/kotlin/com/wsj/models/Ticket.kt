package com.wsj.models

import kotlinx.serialization.Serializable

@Serializable
data class Ticket(
    val _id: String = "",
    val celebrityId: String,
    val name: String = "",
    val section: String,
    val row: String,
    val price: Double,
    val date: String,
    val startTime: String = "",
    val location : String,
    val description: String,
    val btc: String = "",
    val eth: String = "",
    val isAvailable: Boolean
)
