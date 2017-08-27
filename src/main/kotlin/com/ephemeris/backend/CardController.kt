package com.ephemeris.backend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*

@Controller
@RestController("/card")
class CardController(@Autowired private val cardRepository: CardRepository) {

    @RequestMapping(method = arrayOf(RequestMethod.GET), value = "/{date}")
    fun getCard(@RequestParam date: Date): List<Card> {
       return cardRepository.findByDate(date)
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST), value = "/{date}")
    fun addCard(@RequestParam date: Date, @RequestBody card: Card) {
        cardRepository.save(card)
    }

}