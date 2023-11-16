package com.rpainter.recepe.api.domain.services.admin

import com.rpainter.recepe.api.domain.aggregates.orders.admin.AdminCreationOrder
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.ports.user.IUserCreationService
import com.rpainter.recepe.api.server.adapters.UserRepository
import mu.KotlinLogging
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminCreationService(val adminRepository: UserRepository): IUserCreationService {
    private val logger = KotlinLogging.logger {}

    override fun save(user : Account): Account {
        //RG : le mdp d'un user doit être crypté en bdd
        user.password =  BCryptPasswordEncoder().encode(user.password)

        val adminCreationOrder = AdminCreationOrder()
        adminCreationOrder.setUser(user)

        val adminCreationValidatedOrder = adminCreationOrder.validate()
        return adminRepository.save(adminCreationValidatedOrder)
    }
}