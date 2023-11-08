package com.rpainter.recepe.api.controllers

import com.rpainter.recepe.api.entities.ApiUser
import com.rpainter.recepe.api.services.impl.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController(val customerService: UserService) {


    @PostMapping("/api/users/create")
    fun createUser(@RequestBody customer:ApiUser):ResponseEntity<ApiUser> {
        return ResponseEntity.ok( customerService.createUser(customer));
    }
}