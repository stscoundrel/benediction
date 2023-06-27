package io.github.stscoundrel.benediction

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BenedictionApplication

fun main(args: Array<String>) {
	runApplication<BenedictionApplication>(*args)
}
