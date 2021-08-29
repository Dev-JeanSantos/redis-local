package br.com.redislocal.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("userHobbies")
class UserRobbie(
    val idUser:String,
    @Id val nameUser: String,
    var hobbies: List<Hobbies>
)