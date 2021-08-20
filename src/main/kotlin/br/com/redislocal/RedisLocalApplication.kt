package br.com.redislocal

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RedisLocalApplication

fun main(args: Array<String>) {
	runApplication<RedisLocalApplication>(*args)
}
