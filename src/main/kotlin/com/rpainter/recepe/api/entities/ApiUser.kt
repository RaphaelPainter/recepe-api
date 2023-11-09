package com.rpainter.recepe.api.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Builder
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Builder
@Entity
data class ApiUser(var name: String, var email: String, var password: String){

    @Id
    val id: UUID?=UUID.randomUUID()


    val creation_date: LocalDateTime? = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris"))

    private var role: String = Role.USER.toString()

    fun setRole(role:Role){
        this.role = role.toString()
    }

    fun getRole():String{
        return role
    }
}


