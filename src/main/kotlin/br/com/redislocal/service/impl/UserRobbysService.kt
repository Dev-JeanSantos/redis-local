package br.com.redislocal.service.impl

import br.com.redislocal.dto.UserRobbyDTO
import br.com.redislocal.model.UserRobbie
import br.com.redislocal.repository.UserHobbyesRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class UserRobbysService(var repository: UserHobbyesRepository) {

    fun createHobbys(userRobbyDTO: UserRobbyDTO):  UserRobbie {
        return repository.save(UserRobbie(userRobbyDTO.idUser, userRobbyDTO.nameUser, userRobbyDTO.hobbies))
    }

    fun getUserHobby(name: String): UserRobbie = repository.findById(name).orElseThrow() {
        ChangeSetPersister.NotFoundException()
    }

}
