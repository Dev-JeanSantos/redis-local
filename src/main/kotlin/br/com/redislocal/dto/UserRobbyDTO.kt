package br.com.redislocal.dto

import br.com.redislocal.model.Hobbies
import javax.validation.constraints.NotBlank

data class UserRobbyDTO (

    @NotBlank val idUser: String,
    @NotBlank val nameUser: String,
    val hobbies: List<Hobbies>
    )
