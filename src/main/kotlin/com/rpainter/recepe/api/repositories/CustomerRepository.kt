package com.rpainter.recepe.api.repositories

import com.rpainter.recepe.api.entities.Customer
import org.springframework.data.repository.CrudRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository


@Repository
interface CustomerRepository : CrudRepository<Customer, String>
