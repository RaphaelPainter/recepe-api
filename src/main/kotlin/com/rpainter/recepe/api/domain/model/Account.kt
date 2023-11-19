package com.rpainter.recepe.api.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Builder
import java.util.*


@Builder
@Entity
data class Account(var name: String, var email: String, var password: String){

    @Id
    var id: UUID? = null

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


