package com.rpainter.recepe.api.domain.ports.user

import com.rpainter.recepe.api.domain.model.Account

interface IUserCreationService {
    fun save(user: Account): Account
}
