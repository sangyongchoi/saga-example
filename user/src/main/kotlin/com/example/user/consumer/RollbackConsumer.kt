package com.example.user.consumer

import com.example.user.domain.UserRepository
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class RollbackConsumer(
    private val userRepository: UserRepository,
) {

    @KafkaListener(topics = ["rollback_user"], groupId = "group_2")
    fun listenGroupFoo(userId: Long?) {
        userRepository.deleteById(userId!!)
    }
}