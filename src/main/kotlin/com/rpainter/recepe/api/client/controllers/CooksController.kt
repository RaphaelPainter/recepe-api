package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.model.Chef
import com.rpainter.recepe.api.domain.services.cook.CookFindService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping(path = [RootPath.COOK])
@RestController
class CooksController(val cookCreationService: CookFindService, val cookFindService : CookFindService) {
    @GetMapping("")
    fun findAll(): ResponseEntity<MutableIterable<Chef>> {
        return ResponseEntity.ok(cookFindService.findAll());
    }
}