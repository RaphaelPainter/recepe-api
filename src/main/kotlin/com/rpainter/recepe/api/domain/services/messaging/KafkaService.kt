package com.rpainter.recepe.api.domain.services.messaging

import com.rpainter.recepe.api.config.KafkaTopicConfig
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Service
import java.util.concurrent.CompletableFuture


@Service
class KafkaService{
/*

    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    private val logger = KotlinLogging.logger {}

    fun send(topic : KafkaTopicConfig.TOPIC, msg: String) {
        sendToKafka(topic.toString(), msg)
    }

    private fun sendToKafka(topicName : String, msg: String) {
        var lf : CompletableFuture<SendResult<String, String>> = kafkaTemplate?.send(topicName, msg)!!
        println(lf)
    }
*/
}