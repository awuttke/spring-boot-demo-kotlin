package me.wuttke.demo.controllers

import org.hamcrest.Matchers.`is`
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@WebMvcTest(HelloController::class)
class HelloControllerIntegrationTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun testHelloWithoutName() {
        mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/hello")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk)
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", `is`("World")  ))
    }

    @Test
    fun testHelloWithName() {
        mvc.perform(org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get("/hello")
                .param("name", "Fred")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk)
                .andExpect(view().name("hello"))
                .andExpect(model().attribute("user", `is`("Fred")  ))
    }

}