package com.rpainter.recepe.api.controllers

import com.rpainter.recepe.api.entities.Customer
import com.rpainter.recepe.api.services.impl.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController


@RestController
class CustomerController(val customerService: CustomerService) {

    @GetMapping("/customers")
    fun all(): ResponseEntity<MutableIterable<Customer>> {
        return ResponseEntity.ok( customerService.all());
    }

    @PostMapping("/customers")
    fun create(@RequestBody customer:Customer):ResponseEntity<Customer> {
        return ResponseEntity.ok( customerService.create(customer));
    }
}