package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.model.Chef


interface ICookFindService {
    fun findAll(): MutableIterable<Chef>
}