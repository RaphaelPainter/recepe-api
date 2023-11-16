package com.rpainter.recepe.api.domain.services.user

import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.ports.user.IUserRepository
import com.rpainter.recepe.api.domain.ports.user.IUserFindService
import mu.KotlinLogging
import org.springframework.stereotype.Service



@Service
class UserFindService(val userRepository: IUserRepository): IUserFindService {

    private val logger = KotlinLogging.logger {}

    override fun findAll(): MutableIterable<Account> {
        return userRepository.findAll()
    }

    override fun findByEmail(email: String): Account? {
        val user : Account? = userRepository.findAll().firstOrNull{
            it.email == email
        }
        logger.info {email + " found in database ? "+ (user != null) }
        return user
    }
}