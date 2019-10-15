package me.wuttke.demo.controllers

import org.junit.Test
import org.springframework.validation.support.BindingAwareModelMap
import org.junit.Assert.*

class HelloControllerUnitTest {

    @Test
    fun sayHello() {
        val helloController = HelloController()
        val model = BindingAwareModelMap()

        val result = helloController.sayHello("World", model)

        assertEquals("hello", result)
        assertEquals("World", model["user"])
    }
}