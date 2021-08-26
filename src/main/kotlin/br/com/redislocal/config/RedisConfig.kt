package br.com.redislocal.config

import br.com.redislocal.model.UserRobbie
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.CacheManager
import org.springframework.context.annotation.Bean
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer
import org.springframework.data.redis.serializer.RedisSerializationContext
import java.time.Duration

class RedisConfig (
    private val connectionFactory: RedisConnectionFactory,
    private val objectMapper: ObjectMapper,
    @Value("\${spring.application.name}")
    private val applicationName: String

    ){
        @Bean
        fun cacheManager(): CacheManager {
            val redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory)
            val cache1MinuteConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(1))
                .computePrefixWith { name -> "$applicationName:$name:" }
            val jackson2JsonRedisSerializer = Jackson2JsonRedisSerializer(UserRobbie::class.java).apply {
                this.setObjectMapper(objectMapper)
            }
            val cache60MinuteConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(60))
                .computePrefixWith { name -> "$applicationName:$name:" }
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))

            return RedisCacheManager.RedisCacheManagerBuilder.fromCacheWriter(redisCacheWriter)
                .cacheDefaults(cache1MinuteConfiguration)
                .withCacheConfiguration("createInterest", cache1MinuteConfiguration)
                .withCacheConfiguration("getAllInterests", cache1MinuteConfiguration)
                .withCacheConfiguration("getInterest", cache60MinuteConfiguration)
                .withCacheConfiguration("createUser", cache1MinuteConfiguration)
                .withCacheConfiguration("getAllUsers", cache1MinuteConfiguration)
                .withCacheConfiguration("getUser", cache60MinuteConfiguration)
                .build()
        }
    }