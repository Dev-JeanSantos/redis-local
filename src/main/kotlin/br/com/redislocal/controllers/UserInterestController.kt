package br.com.redislocal.controllers

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/user-interests")
class UserInterestController {

    private val logger: org.slf4j.Logger = LoggerFactory.getLogger(this::class.java)


}