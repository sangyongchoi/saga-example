package com.example.user.web

import com.example.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService,
) {

    @PostMapping("/sign-up")
    fun signUp(@RequestParam userId: String) = userService.signUp(userId)
}