package br.com.redislocal.repository

import br.com.redislocal.model.UserRobbie
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserHobbyesRepository : CrudRepository<UserRobbie, String>