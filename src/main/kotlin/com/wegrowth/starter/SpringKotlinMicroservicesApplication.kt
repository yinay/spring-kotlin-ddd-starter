package com.wegrowth.starter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringKotlinMicroservicesApplication

fun main(args: Array<String>) {
    runApplication<SpringKotlinMicroservicesApplication>(*args)
}
