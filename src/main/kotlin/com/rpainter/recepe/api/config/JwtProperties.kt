package com.rpainter.recepe.api.config

import io.jsonwebtoken.Jwts
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("jwt")
public class JwtProperties(
    val key : String,
    val accessTokenExpiration: Long,
    val refreshTokenExpiration: Long,
)

