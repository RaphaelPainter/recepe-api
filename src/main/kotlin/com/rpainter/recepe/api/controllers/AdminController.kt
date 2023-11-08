package com.rpainter.recepe.api.controllers

import com.rpainter.recepe.api.entities.ApiUser
import com.rpainter.recepe.api.services.impl.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController


@RestController
class AdminController(val customerService: UserService) {

    @GetMapping("/api/admin/users")
    fun all(): ResponseEntity<MutableIterable<ApiUser>> {
        return ResponseEntity.ok( customerService.all());
    }

    @PostMapping("/api/admin/users/create")
    fun createAdmin(@RequestBody customer:ApiUser):ResponseEntity<ApiUser> {
        return ResponseEntity.ok( customerService.createUser(customer));
    }

}