package com.rpainter.recepe.api.services.itf

import com.rpainter.recepe.api.entities.ApiUser

interface IUserService {
    fun all() : MutableIterable<ApiUser>;
    fun findByEmail(email : String) : ApiUser?;

    fun createUser(customer: ApiUser): ApiUser
    fun createAdmin(customer: ApiUser): ApiUser
}