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

    @GetMapping(value = ["/{name}"])
    private fun getUserRobbysByName(@Validated @PathVariable name: String): ResponseEntity<UserRobbyDTO>{
        logger.info("Iniciei meu endpoint! Nome a ser buscado: $name")
        val userHobby = userRobbysService.getUserHobby(name)
       return ResponseEntity.ok().body(UserRobbyDTO(idUser = userHobby.idUser, nameUser = userHobby.nameUser, hobbies = userHobby.hobbies))
    }

    @PostMapping
    private fun saveUserRobbys(@Validated @RequestBody userRobbyDTO: UserRobbyDTO): ResponseEntity<UserRobbyDTO>{
        logger.info("Iniciei meu endpoint!")
        val userHobbie = userRobbysService.createHobbys(userRobbyDTO)
        logger.info("Finalizou meu endpoint! ${userHobbie.nameUser}")
        return ResponseEntity.ok().body(UserRobbyDTO(idUser = userHobbie.idUser, nameUser = userHobbie.nameUser, hobbies = userHobbie.hobbies))
    }




}