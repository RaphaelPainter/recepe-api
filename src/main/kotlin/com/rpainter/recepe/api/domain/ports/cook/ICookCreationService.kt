package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.model.Chef


interface ICookCreationService {
    fun save(cook: Chef): Chef
}