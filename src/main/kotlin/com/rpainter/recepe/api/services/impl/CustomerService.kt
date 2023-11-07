package com.rpainter.recepe.api.services.impl

import com.rpainter.recepe.api.entities.Customer
import com.rpainter.recepe.api.repositories.CustomerRepository
import com.rpainter.recepe.api.services.itf.ICustomerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service




@Service
class CustomerService(val customerRepository: CustomerRepository) : ICustomerService {
    @Autowired
    private val environment: Environment? = null

    override fun all(): MutableIterable<Customer> {
        return customerRepository.findAll();
    }

    override fun create(customer : Customer): Customer {
        //customer name should be unique
        return customerRepository.save(customer);
    }

    override fun findByEmail(email: String): Customer? {
        return customerRepository.findAll().firstOrNull{
            it.email == email
        }
    }
}