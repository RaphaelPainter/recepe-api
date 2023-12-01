package com.rpainter.recepe.api.domain.ports.user

import com.rpainter.recepe.api.domain.model.Account

interface IUserFindService {
    fun findByEmail(email : String) : Account?;
    fun findAll(): MutableIterable<Account>
}