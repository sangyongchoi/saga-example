package com.example.user.producer

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class PointProducer(
    private val kafkaTemplate: KafkaTemplate<String, Long?>,
) {

    fun signUpGift(id: Long?) {
        kafkaTemplate.send("singup_user", id)
    }
}