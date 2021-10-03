package com.example.point.consumer

import com.example.point.producer.UserProducer
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.lang.RuntimeException

@Component
class UserCreatedConsumer(
    private val userProducer: UserProducer,
) {

    var count = 0

    @KafkaListener(topics = ["singup_user"], groupId = "group_1")
    fun listenGroupFoo(message: Long?) {
        try {
            count++
            if (count % 2 == 0) {
                addPoint(message)
            } else {
                throw RuntimeException("Error!!!")
            }

        } catch (e: Exception) {
            rollback(message)
        }
    }

    private fun addPoint(message: Long?) {
        println("gift point to user. userId: $message")
    }

    private fun rollback(message: Long?) {
        println("rollback. userId: $message")
        userProducer.rollback(message)
    }
}