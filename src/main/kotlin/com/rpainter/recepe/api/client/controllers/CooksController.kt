package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Cook
import com.rpainter.recepe.api.domain.services.cook.CookCreationService
import com.rpainter.recepe.api.domain.services.cook.CookFindService
import lombok.Getter
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping(path = [RootPath.COOK])
@RestController
class CooksController(val cookCreationService: CookFindService, val cookFindService : CookFindService) {
    @GetMapping("")
    fun findAll(): ResponseEntity<MutableIterable<Cook>> {
        return ResponseEntity.ok(cookFindService.findAll());
    }
}