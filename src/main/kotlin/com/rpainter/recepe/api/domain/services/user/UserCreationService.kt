package com.rpainter.recepe.api.domain.services.user

import com.rpainter.recepe.api.domain.aggregates.orders.user.UserCreationOrder
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.ports.user.IUserRepository
import com.rpainter.recepe.api.domain.ports.user.IUserCreationService
import mu.KotlinLogging
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service



@Service
class UserCreationService(val userRepository: IUserRepository): IUserCreationService {

    private val logger = KotlinLogging.logger {}

    override fun save(user : Account): Account {
        //RG : le mdp d'un user doit être crypté en bdd
        user.password =  BCryptPasswordEncoder().encode(user.password)

        val userCreationOrder = UserCreationOrder()
        userCreationOrder.setUser(user)

        val userCreationValidatedOrder = userCreationOrder.validate()
        return userRepository.save(userCreationValidatedOrder)
    }
}