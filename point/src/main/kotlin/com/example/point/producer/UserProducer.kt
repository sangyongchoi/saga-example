package com.example.point.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class UserProducer(
    private val kafkaTemplate: KafkaTemplate<String, Long?>,
) {

    fun rollback(userId: Long?) {
        kafkaTemplate.send("rollback_user", userId)
    }
}