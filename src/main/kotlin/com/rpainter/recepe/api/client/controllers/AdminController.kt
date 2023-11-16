package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.services.user.UserFindService
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.services.admin.AdminCreationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(path = [RootPath.ADMIN])
class AdminController(val userFindService: UserFindService, val adminCreationService: AdminCreationService) {

    @PostMapping("/create")
    fun createAdmin(@RequestBody user: Account):ResponseEntity<Account> {
        return ResponseEntity.ok(adminCreationService.save(user));
    }

}