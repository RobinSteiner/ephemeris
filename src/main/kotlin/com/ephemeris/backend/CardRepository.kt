package com.ephemeris.backend

import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface CardRepository : MongoRepository<Card, Long> {

    fun findByDate(date: Date): List<Card>
}