package com.example.cat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CaTApplication

fun main(args: Array<String>) {
    runApplication<CaTApplication>(*args)
}
