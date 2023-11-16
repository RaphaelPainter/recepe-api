package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.model.Cook


interface ICookCreationService {
    fun save(cook: Cook): Cook
}