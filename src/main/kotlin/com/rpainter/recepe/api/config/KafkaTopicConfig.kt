package com.rpainter.recepe.api.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaAdmin
import org.springframework.context.annotation.Configuration


@Configuration
class KafkaTopicConfig {
    /*@Value(value = "\${spring.kafka.bootstrap-servers}")
    private val bootstrapAddress: String? = null
    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs: MutableMap<String, Any?> = HashMap()
        configs[AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapAddress
        return KafkaAdmin(configs)
    }

    @Bean
    fun topic1(): NewTopic {
        return NewTopic("baeldung", 1, 1.toShort())
    }

    enum class TOPIC {
        connections
    }*/
}