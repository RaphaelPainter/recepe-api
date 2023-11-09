package com.rpainter.recepe.api.Helper

import com.rpainter.recepe.api.entities.ApiUser

data class ApiTestUser(private val apiUser: ApiUser, private val token : String) {
    fun getEmail():String{
        return apiUser.email
    }

    fun getPassword():String{
        return apiUser.password
    }

    fun getAccessToken():String{
        return token
    }
}

