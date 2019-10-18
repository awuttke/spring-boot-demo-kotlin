package me.wuttke.demo

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit4.SpringRunner
import java.text.NumberFormat

@RunWith(SpringRunner::class)
@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private lateinit var ctx: ApplicationContext

	@Autowired
	private lateinit var numberFormat: NumberFormat

	@Test
	fun defaultCurrency() {
		val amount = 4711.15
		println("Betrag: ${numberFormat.format(amount)}")
	}

	@Test
	fun contextLoads() {
		val count = ctx.beanDefinitionCount
		println("Numer of Beans: $count")
	}

}
