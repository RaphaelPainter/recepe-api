package com.rpainter.recepe.api.domain.model

import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Builder
import java.util.*


@Builder
@Entity
data class Account(var name: String,   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) var email: String,
                   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) var password: String){


    @Id
    var id: String? = null

    private lateinit var role:String

    fun setRole(accountRole:AccountRole){
        this.role = accountRole.toString()
    }
    fun getRole(): AccountRole {
        return AccountRole.valueOf(this.role)
    }


    enum class AccountRole{
        USER, ADMIN
    }
}


