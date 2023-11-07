package com.rpainter.recepe.api.controllers

import com.rpainter.recepe.api.services.impl.AuthenticationService

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationService: AuthenticationService
) {
    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest
    ): AuthenticationResponse =
        authenticationService.authentication(authRequest)
}

data class AuthenticationRequest(
    val email: String,
    val password: String,
)

data class AuthenticationResponse(
    val accessToken: String,
)