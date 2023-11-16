package com.rpainter.recepe.api.domain.services.cook

import com.rpainter.recepe.api.domain.model.Cook
import com.rpainter.recepe.api.domain.ports.cook.ICookFindService
import com.rpainter.recepe.api.domain.ports.cook.ICookRepository
import mu.KotlinLogging
import org.springframework.stereotype.Service

@Service
class CookFindService(val cookRepository : ICookRepository): ICookFindService {
    private val logger = KotlinLogging.logger {}

    override fun findAll(): MutableIterable<Cook> {
        return cookRepository.findAll()
    }
}