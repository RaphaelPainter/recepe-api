package com.rpainter.recepe.api.domain.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*
import lombok.Builder
import java.util.*

@Builder
@Entity
data class Chef(
    @Id
    var id: String? = null){

    var name: String?=null

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    var account:Account?=null
}