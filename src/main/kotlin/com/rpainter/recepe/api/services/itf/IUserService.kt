package com.rpainter.recepe.api.services.itf

import com.rpainter.recepe.api.entities.ApiUser
import com.rpainter.recepe.api.entities.ApiUsers

interface IUserService {
    fun findByEmail(email : String) : ApiUser?;

    fun createUser(customer: ApiUser): ApiUser
    fun createAdmin(customer: ApiUser): ApiUser
    fun findAll(): ApiUsers
}