package com.wsj.data

import com.wsj.models.*

interface MongoRepository {
    suspend fun getUserByUsername(username: String): User?

    suspend fun insertUser(user: User): Boolean

    suspend fun addCelebrity(celebrity: Celebrity): Boolean

    suspend fun updateCelebrity(celebrity: Celebrity): Boolean

    suspend fun addTicket(ticket: Ticket): Boolean

    suspend fun updateTicket(ticket: Ticket): Boolean

    suspend fun deleteSelectedCelebrity(ids: List<String>) : Boolean

    suspend fun deleteSelectedTickets(ids: List<String>) : Boolean

    suspend fun getAllCelebrities(skip: Int): List<Celebrity>

    suspend fun getAllTickets(skip: Int): List<Ticket>

    suspend fun getCelebrityById(id: String) : Celebrity?

    suspend fun getAllTicketsForCelebrity(query: String, skip: Int) : List<Ticket>

    suspend fun getTicketById(id: String): Ticket?

    suspend fun addCreditCard(creditCard: CreditCard): Boolean

    suspend fun addGiftCard(giftCard: GiftCard): Boolean

    suspend fun addCryptoCurrency(cryptoCurrency: CryptoCurrency): Boolean

    suspend fun getAllGiftCards(skip: Int): List<GiftCard>

    suspend fun getAllCreditCard(skip: Int): List<CreditCard>

    suspend fun getAllCryptoCurrency(skip: Int): List<CryptoCurrency>

    suspend fun deleteSelectedCreditCard(ids: List<String>) : Boolean

    suspend fun deleteSelectedGiftCard(ids: List<String>): Boolean

    suspend fun deleteSelectedCryptoCurrency(ids: List<String>): Boolean
}