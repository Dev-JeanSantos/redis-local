package br.com.redislocal.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("userHobbies")
class UserRobbie(
    @Id val idUser:String,
    val nameUser: String,
    var hobbies: List<Hobbies>
)