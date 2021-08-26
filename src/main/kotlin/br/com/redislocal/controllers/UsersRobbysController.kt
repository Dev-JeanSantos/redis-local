package br.com.redislocal.controllers

import br.com.redislocal.dto.UserRobbyDTO
import br.com.redislocal.service.impl.UserRobbysService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/user-robbys")
class UsersRobbysController(private var userRobbysService: UserRobbysService) {
    private val logger: org.slf4j.Logger = LoggerFactory.getLogger(this::class.java)

    @GetMapping()
    private fun getUserRobbys(): String{
        logger.info("Iniciei meu endpoint!")
        return "Vamos que vamos"

    }

    @PostMapping
    private fun saveUserRobbys(@Validated @RequestBody userRobbyDTO: UserRobbyDTO): ResponseEntity<UserRobbyDTO>{
        logger.info("Iniciei meu endpoint!")
        val userHobbie = userRobbysService.createHobbys(userRobbyDTO)
        logger.info("Finalizou meu endpoint! ${userHobbie.nameUser}")
        return ResponseEntity.ok().body(UserRobbyDTO(idUser = userHobbie.idUser, nameUser = userHobbie.nameUser, hobbies = userHobbie.hobbies))
    }




}