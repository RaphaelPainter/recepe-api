package com.rpainter.recepe.api.domain.services.cook

import com.rpainter.recepe.api.domain.aggregates.orders.cook.CookCreationOrder
import com.rpainter.recepe.api.domain.model.Cook
import com.rpainter.recepe.api.domain.ports.cook.ICookCreationService
import com.rpainter.recepe.api.domain.ports.cook.ICookRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CookCreationService(val cookRepository : ICookRepository): ICookCreationService {
    private val logger = KotlinLogging.logger {}
    override fun save(cook: Cook): Cook {
        val cookCreationOrder = CookCreationOrder()
        cookCreationOrder.setCook(cook)

        val userCreationValidatedOrder = cookCreationOrder.validate()
        return cookRepository.save(userCreationValidatedOrder)
    }
}