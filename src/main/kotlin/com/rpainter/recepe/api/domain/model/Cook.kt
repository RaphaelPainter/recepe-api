package com.rpainter.recepe.api.domain.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import lombok.Builder
import org.jetbrains.annotations.NotNull
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*


@Builder
@Entity
data class Cook(var name: String){

    @Id
    var id: UUID? = null


    var creation_date = LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris"))

    @ManyToOne
    @NotNull
    lateinit var users_fk : Account
}

