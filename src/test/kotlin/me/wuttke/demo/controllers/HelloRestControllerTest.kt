package me.wuttke.demo.controllers

import me.wuttke.demo.entities.Greeting
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.boot.test.web.client.getForObject
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloRestControllerTest {
    @Autowired
    private lateinit var template: TestRestTemplate

     @Test
     fun greetWithoutName() {
         val entity: ResponseEntity<Greeting> = template.getForEntity("/rest", Greeting::class )
         assertEquals(HttpStatus.OK, entity.statusCode)
         assertEquals(MediaType.APPLICATION_JSON_UTF8, entity.headers.contentType)
         val response = entity.body
         if (response != null) {
             assertEquals("Hello, World!", response.message)
         }
     }

    @Test
    fun greetingWithName() {
        val response: Greeting? = template.getForObject("/rest?name=Andy", Greeting::class)
        if (response != null) {
            assertEquals("Hello, Andy!", response.message)
        }
    }
}