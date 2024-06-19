package com.wsj.routes

import com.wsj.data.MongoRepository
import com.wsj.models.CreditCard
import com.wsj.models.CryptoCurrency
import com.wsj.models.GiftCard
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import org.bson.codecs.ObjectIdGenerator

fun Route.addCreditCard(
    mongoRepository: MongoRepository
) {
    post ("/addCreditCard"){
        try {
            val creditCard = call.receive<CreditCard>()
            val newCreditCard = creditCard.copy(_id = ObjectIdGenerator().generate().toString())
            val inserted = coroutineScope {
                async { mongoRepository.addCreditCard(newCreditCard) }
            }.await()
            if (inserted) {
                call.respond(HttpStatusCode.Created, "Credit Card added successfully")
            } else {
                call.respond(HttpStatusCode.InternalServerError)
            }
        } catch (e: Exception) {
            call.respond(e.message.toString())
        }
    }
}

fun Route.addCryptoPayment(
    mongoRepository: MongoRepository
) {
    post ("/addCryptoPayment"){
        try {
            val crypto = call.receive<CryptoCurrency>()
            val newCrypto = crypto.copy(_id = ObjectIdGenerator().generate().toString())
            val inserted = coroutineScope {
                async { mongoRepository.addCryptoCurrency(newCrypto) }
            }.await()
            if (inserted) {
                call.respond(HttpStatusCode.Created, "Crypto Payment added successfully")
            } else {
                call.respond(HttpStatusCode.InternalServerError)
            }
        } catch (e: Exception) {
            call.respond(e.message.toString())
        }
    }
}

fun Route.addGiftCard(
    mongoRepository: MongoRepository
) {
    post ("/addGiftCard"){
        try {
            val giftCard = call.receive<GiftCard>()
            val newGiftCard = giftCard.copy(_id = ObjectIdGenerator().generate().toString())
            val inserted = coroutineScope {
                async { mongoRepository.addGiftCard(newGiftCard) }
            }.await()
            if (inserted) {
                call.respond(HttpStatusCode.Created, "Gift Card added successfully")
            } else {
                call.respond(HttpStatusCode.InternalServerError)
            }
        } catch (e: Exception) {
            call.respond(e.message.toString())
        }
    }
}