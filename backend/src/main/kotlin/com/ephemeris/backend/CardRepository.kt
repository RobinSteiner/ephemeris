package com.ephemeris.backend

import org.springframework.data.mongodb.repository.MongoRepository
import java.math.BigInteger
import java.util.*

interface CardRepository : MongoRepository<Card, BigInteger> {

    fun findByDate(date: Date): List<Card>
}