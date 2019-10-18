package me.wuttke.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.text.NumberFormat

@SpringBootApplication
class DemoApplication {

	fun main(args: Array<String>) {
		runApplication<DemoApplication>(*args)
	}

	@Bean
	fun defaultCurrencyFormat() : NumberFormat {
		return NumberFormat.getCurrencyInstance()
	}
}

