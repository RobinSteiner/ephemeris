package com.ephemeris.backend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

//Create a document class
//that persists to the DB
@Document
data class Restaurant(
        //Mark this field as the document id
        @field: Id var name : String = "",
        //Unstructured Data Here
        var employees : List<Employee> = mutableListOf())

//This class embeds directly into Restaurant
//without any annotations
data class Employee(var name : String = "",
                    var position : String = "")

@Configuration
@EnableMongoRepositories //Allow Spring to Generate Mongo Repositories
class Config

//Spring will implement our interface for us!
interface RestaurantRepository : MongoRepository<Restaurant, Long>

//Example Controller class for demonstration purposes
@Controller
@RestController("/getRestaurants")
class IndexController(
        //We can inject our RestaurantRepository class, Spring will
        //provide an implementation
        @Autowired private val restaurantRepository: RestaurantRepository){

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun doGet() : List<Restaurant> {
        return restaurantRepository.findAll()
    }

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun doPost(@RequestParam("name") name : String,
               @RequestParam("employees") employees : String) : String {
        val restaurant = Restaurant(name = name,
                employees = parseEmployees(employees))
        //Save the new restaurant
        restaurantRepository.save(restaurant)
        return "index"
    }

    fun parseEmployees(employees : String) : List<Employee> {
        val employeeList = mutableListOf<Employee>()
        val parts = employees.split('\n')

        parts.forEach {
            val subParts = it.split(",")
            employeeList.add(
                    Employee(name = subParts[0],
                            position = subParts[1]))
        }
        return employeeList.toList()
    }
}