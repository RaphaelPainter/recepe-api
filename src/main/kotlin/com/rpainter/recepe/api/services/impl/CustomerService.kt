package com.rpainter.recepe.api.services.impl

import com.rpainter.recepe.api.entities.Customer
import com.rpainter.recepe.api.repositories.CustomerRepository
import com.rpainter.recepe.api.services.itf.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(val customerRepository: CustomerRepository) : ICustomerService {

    override fun all(): MutableIterable<Customer> {
        return customerRepository.findAll();
    }


}