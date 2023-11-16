package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.config.KafkaTopicConfig
import com.rpainter.recepe.api.domain.services.auth.AuthenticationService
import com.rpainter.recepe.api.domain.services.messaging.KafkaService

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(path = [RootPath.AUTH])
class AuthController(
    private val authenticationService: AuthenticationService,
    private val kafkaService: KafkaService
    ) {
    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest
    ): AuthenticationResponse {
        kafkaService.send(KafkaTopicConfig.TOPIC.connections, "i am connected")
        return  authenticationService.authentication(authRequest)
    }
}

data class AuthenticationRequest(
    val email: String,
    val password: String,
)

data class AuthenticationResponse(
    val accessToken: String,
)