package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Cook


interface ICookFindService {
    fun findAll(): MutableIterable<Cook>
}