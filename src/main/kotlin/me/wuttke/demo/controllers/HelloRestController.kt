package me.wuttke.demo.controllers

import me.wuttke.demo.entities.Greeting
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloRestController {

    @GetMapping("/rest")
    fun greet(@RequestParam(required = false, defaultValue = "World") name: String) : Greeting {

        return Greeting("Hello, $name!")
    }
}
