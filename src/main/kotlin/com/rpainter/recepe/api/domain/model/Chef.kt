package com.rpainter.recepe.api.domain.model

import jakarta.persistence.*
import lombok.Builder
import java.util.*

@Builder
@Entity
data class Chef(
    @Id
    var id: UUID? = null){

    var name: String?=null

    @OneToOne
    var account:Account?=null
}