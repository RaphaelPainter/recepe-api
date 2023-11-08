package com.rpainter.recepe.api.services.impl

import com.rpainter.recepe.api.config.JwtProperties
import com.rpainter.recepe.api.controllers.AuthenticationRequest
import com.rpainter.recepe.api.controllers.AuthenticationResponse
import io.jsonwebtoken.Jwts
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.*
import mu.KotlinLogging

@Service
class AuthenticationService(
    private val authManager: AuthenticationManager,
    private val userDetailsService: CustomUserDetailsService.CustomUserDetailsService,
    private val tokenService: TokenService,
    private val jwtProperties: JwtProperties,
) {

    private val logger = KotlinLogging.logger {}


    fun authentication(authenticationRequest: AuthenticationRequest): AuthenticationResponse {

        authManager.authenticate(
            UsernamePasswordAuthenticationToken(
                authenticationRequest.email,
                authenticationRequest.password
            )
        )
        logger.info { authenticationRequest.email + " is authenticated" }

        val user = userDetailsService.loadUserByUsername(authenticationRequest.email)
        val accessToken = createAccessToken(user)
        logger.info {"accessToken generated : " + accessToken  }

        return AuthenticationResponse(
            accessToken = accessToken,
        )
    }
    private fun createAccessToken(user: UserDetails) = tokenService.generate(
        userDetails = user,
        expirationDate = getAccessTokenExpiration()
    )
    private fun getAccessTokenExpiration(): Date =
        Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
}