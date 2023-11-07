package com.rpainter.recepe.api.services.itf

import com.rpainter.recepe.api.entities.Customer

interface ICustomerService {
    fun all() : MutableIterable<Customer>;
}