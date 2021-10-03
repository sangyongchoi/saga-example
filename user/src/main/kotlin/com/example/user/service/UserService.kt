package com.example.user.service

import com.example.user.domain.User
import com.example.user.domain.UserRepository
import com.example.user.producer.PointProducer
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val pointProducer: PointProducer,
) {

    fun signUp(loginId: String): Long {
        val user = User(loginId = loginId)
        userRepository.save(user)
        pointProducer.signUpGift(user.id)
        return user.id!!
    }
}