package com.wsj.routes

import com.wsj.Utils.ID
import com.wsj.Utils.SKIP_PARAM
import com.wsj.data.MongoRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.getCreditCard(
    mongoRepository: MongoRepository
){
    get("/getCreditCard"){
        try {
            val skip = call.parameters[SKIP_PARAM]?.toInt() ?: 0
            val creditCards = mongoRepository.getAllCreditCard(
                skip = skip
            )
            call.respond(HttpStatusCode.OK, creditCards)
        } catch (e: Exception) {
            call.respond(e.message.toString())
        }
    }
}

fun Route.getCryptoCurrency(
    mongoRepository: MongoRepository
){
    get("/getCryptoCurrency"){
        try {
            val skip = call.parameters[SKIP_PARAM]?.toInt() ?: 0
            val cryptoCurrencies = mongoRepository.getAllCryptoCurrency(
                skip = skip
            )
            call.respond(HttpStatusCode.OK, cryptoCurrencies)
        } catch (e: Exception) {
            call.respond(e.message.toString())
        }
    }
}

fun Route.getGiftCard(
    mongoRepository: MongoRepository
){
    get("/getGiftCard"){
        try {
            val skip = call.parameters[SKIP_PARAM]?.toInt() ?: 0
            val giftCards = mongoRepository.getAllGiftCards(
                skip = skip
            )
            call.respond(HttpStatusCode.OK, giftCards)
        } catch (e: Exception) {
            call.respond(e.message.toString())
        }
    }
}

fun Route.deleteSelectedCreditCard(
    mongoRepository: MongoRepository
){
    delete("/deleteSelectedCreditCard/{id}") {
        val id = call.parameters[ID] ?: return@delete call.respond(HttpStatusCode.BadRequest, "Missing ID")
        try {
            val delete = mongoRepository.deleteSelectedCreditCard(listOf(id))
            if (delete) {
                call.respond(HttpStatusCode.OK, "Credit Card with the ID $id Deleted Successfully")
            } else {
                call.respond(HttpStatusCode.NotFound, "Credit Card with the ID $id not found")
            }
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, "Error occurred while processing request: ${e.message}")
        }
    }
}

fun Route.deleteSelectedGiftCard(
    mongoRepository: MongoRepository
){
    delete("/deleteSelectedGiftCard/{id}") {
        val id = call.parameters[ID] ?: return@delete call.respond(HttpStatusCode.BadRequest, "Missing ID")
        try {
            val delete = mongoRepository.deleteSelectedGiftCard(listOf(id))
            if (delete) {
                call.respond(HttpStatusCode.OK, "Gift Card with the ID $id Deleted Successfully")
            } else {
                call.respond(HttpStatusCode.NotFound, "Gift Card with the ID $id not found")
            }
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, "Error occurred while processing request: ${e.message}")
        }
    }
}

fun Route.deleteSelectedCryptoCurrency(
    mongoRepository: MongoRepository
){
    delete("/deleteSelectedCryptoCurrency/{id}") {
        val id = call.parameters[ID] ?: return@delete call.respond(HttpStatusCode.BadRequest, "Missing ID")
        try {
            val delete = mongoRepository.deleteSelectedCryptoCurrency(listOf(id))
            if (delete) {
                call.respond(HttpStatusCode.OK, "Crypto Currency with the ID $id Deleted Successfully")
            } else {
                call.respond(HttpStatusCode.NotFound, "Crypto Currency with the ID $id not found")
            }
        } catch (e: Exception) {
            call.respond(HttpStatusCode.InternalServerError, "Error occurred while processing request: ${e.message}")
        }
    }
}