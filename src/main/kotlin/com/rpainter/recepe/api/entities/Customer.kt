package com.rpainter.recepe.api.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.Builder
import java.time.Instant
import java.time.LocalDate
import java.util.*

@Builder
@Entity
data class Customer( var name: String, var email: String, var encryptedPassword: String, var role:String){

    @Id
    val id: UUID?=UUID.randomUUID()

    val creation_date: Instant? = Instant.now()

}


