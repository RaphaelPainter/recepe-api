package com.rpainter.recepe.api.services.impl

import com.rpainter.recepe.api.entities.ApiUser
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

typealias ApplicationUser = ApiUser

class CustomUserDetailsService {
    @Service
    class CustomUserDetailsService(
        private val userService: UserService
    ) : UserDetailsService {
        override fun loadUserByUsername(username: String): UserDetails =
            userService.findByEmail(username)
                ?.mapToUserDetails()
                ?: throw UsernameNotFoundException("Not found!")
        private fun ApplicationUser.mapToUserDetails(): UserDetails =
            User.builder()
                .username(this.email)
                .password(this.encryptedPassword)
                .roles(this.getRole())
                .build()
    }
}