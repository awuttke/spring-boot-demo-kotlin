package me.wuttke.demo.controllers

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HelloController {

    @GetMapping("/hello")
    fun sayHello(
            @RequestParam(defaultValue = "World", required = false)
            name: String,
            model: Model) : String {

        model.addAttribute("user", name)

        return "hello"
    }
}