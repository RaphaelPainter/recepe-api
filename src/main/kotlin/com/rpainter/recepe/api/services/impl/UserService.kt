package com.rpainter.recepe.api.services.impl

import com.rpainter.recepe.api.entities.Role
import com.rpainter.recepe.api.entities.ApiUser
import com.rpainter.recepe.api.repositories.UserRepository
import com.rpainter.recepe.api.services.itf.IUserService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service




@Service
class UserService(val userRepository: UserRepository) : IUserService {
    @Autowired
    private val environment: Environment? = null
    private val logger = KotlinLogging.logger {}

    override fun all(): MutableIterable<ApiUser> {
        return userRepository.findAll();
    }



    override fun createUser(user : ApiUser): ApiUser {
        user.encryptedPassword = BCryptPasswordEncoder().encode(user.encryptedPassword)
        user.setRole(Role.USER)
        val res = userRepository.save(user)
        logger.info {user.email + " saved to database " }
        return res;
    }

    override fun createAdmin(user : ApiUser): ApiUser {
        user.encryptedPassword = BCryptPasswordEncoder().encode(user.encryptedPassword)
        user.setRole(Role.ADMIN)
        val res = userRepository.save(user)
        logger.info {user.email + " saved to database " }
        return res;
    }

    override fun findByEmail(email: String): ApiUser? {
        val user : ApiUser? = userRepository.findAll().firstOrNull{
            it.email == email
        }
        logger.info {email + " found in database ? "+ (user != null) }
        return user
    }
}