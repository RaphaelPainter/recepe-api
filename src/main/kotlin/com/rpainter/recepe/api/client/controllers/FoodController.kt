package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.services.food.FoodFindService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping(path = [RootPath.FOOD])
@RestController
class FoodController( val foodFindService: FoodFindService) {
    @GetMapping("")
    fun findAll(): ResponseEntity<MutableIterable<Ingredient>> {
        return ResponseEntity.ok(foodFindService.findSeasonalFood());
    }
}