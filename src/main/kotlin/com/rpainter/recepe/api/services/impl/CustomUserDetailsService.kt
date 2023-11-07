package com.rpainter.recepe.api.services.impl

import com.rpainter.recepe.api.entities.Customer
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

typealias ApplicationUser = Customer

class CustomUserDetailsService {
    @Service
    class CustomUserDetailsService(
        private val userRepository: CustomerService
    ) : UserDetailsService {
        override fun loadUserByUsername(username: String): UserDetails =
            userRepository.findByEmail(username)
                ?.mapToUserDetails()
                ?: throw UsernameNotFoundException("Not found!")
        private fun ApplicationUser.mapToUserDetails(): UserDetails =
            User.builder()
                .username(this.email)
                .password(this.password)
                .roles(this.role.name)
                .build()
    }
}