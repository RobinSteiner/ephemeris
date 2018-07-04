package com.ephemeris.backend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.math.BigInteger
import java.util.*

@RestController("/card")
class CardController(@Autowired private val cardRepository: CardRepository) {

    @GetMapping
    fun getCards(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("date") date: Date): List<Card> {
        return cardRepository.findByDate(date)
    }

    @PutMapping
    fun addCard(@RequestBody card: Card) {
        cardRepository.save(card)
    }

    @DeleteMapping
    fun deleteCard(@RequestParam("id") id: BigInteger) {
        cardRepository.delete(id)
    }

    @PostMapping
    fun updateCard(@RequestParam("id") id: BigInteger, @RequestBody updatedCard: Card) {
        updatedCard.id = id
        cardRepository.save(updatedCard)
    }


}