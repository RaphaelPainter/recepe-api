package com.rpainter.recepe.api.config

import com.rpainter.recepe.api.domain.services.auth.CustomUserDetailsService
import com.rpainter.recepe.api.domain.services.user.UserFindService
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

@Configuration
@EnableConfigurationProperties(JwtProperties::class)
class Configuration{

    @Bean
    fun userDetailsService(userFindService: UserFindService): UserDetailsService =
        CustomUserDetailsService.CustomUserDetailsService(userFindService)

    @Bean
    fun authenticationProvider(customerService: UserFindService): AuthenticationProvider =
        DaoAuthenticationProvider()
            .also {
                it.setUserDetailsService(userDetailsService(customerService))
                it.setPasswordEncoder( BCryptPasswordEncoder())
            }
    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager =
        config.authenticationManager

}