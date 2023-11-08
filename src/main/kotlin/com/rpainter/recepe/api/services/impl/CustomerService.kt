package com.rpainter.recepe.api.services.impl

import com.rpainter.recepe.api.entities.Customer
import com.rpainter.recepe.api.repositories.CustomerRepository
import com.rpainter.recepe.api.services.itf.ICustomerService
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service




@Service
class CustomerService(val customerRepository: CustomerRepository) : ICustomerService {
    @Autowired
    private val environment: Environment? = null
    private val logger = KotlinLogging.logger {}

    override fun all(): MutableIterable<Customer> {
        return customerRepository.findAll();
    }

    override fun create(customer : Customer): Customer {
        customer.encryptedPassword = BCryptPasswordEncoder().encode(customer.encryptedPassword)
        val res = customerRepository.save(customer)
        logger.info {customer.email + " saved to database " }
        return res;
    }

    override fun findByEmail(email: String): Customer? {
        val customer : Customer? = customerRepository.findAll().firstOrNull{
            it.email == email
        }
        logger.info {email + " found in database ? "+ (customer != null) }
        return customer
    }
}