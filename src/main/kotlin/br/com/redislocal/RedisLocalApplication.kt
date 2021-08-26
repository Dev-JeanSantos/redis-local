package br.com.redislocal

import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@EnableAutoConfiguration
class RedisLocalApplication

fun main(args: Array<String>) {
	runApplication<RedisLocalApplication>(*args)
}
