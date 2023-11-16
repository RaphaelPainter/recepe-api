package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.services.user.UserCreationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping(path = [RootPath.USER])
@RestController
class UserController(val userCreationService: UserCreationService) {
    @PostMapping("/create")
    fun createUser(@RequestBody user: Account):ResponseEntity<Account> {
        return ResponseEntity.ok(userCreationService.save(user));
    }
}