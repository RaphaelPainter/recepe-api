package com.rpainter.recepe.api.domain.services.auth

import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.services.user.UserFindService
import org.springframework.security.core.userdetails.User

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

class CustomUserDetailsService {
    @Service
    class CustomUserDetailsService(
        private val userService: UserFindService
    ) : UserDetailsService {
        override fun loadUserByUsername(username: String): UserDetails =
            userService.findByEmail(username)
                ?.mapToUserDetails()
                ?: throw UsernameNotFoundException("Not found!")

        private fun Account.mapToUserDetails(): UserDetails =
            User.builder()
                .username(this.email)
                .password(this.password)
                .roles(this.getRole().toString())
                .build()
    }
}