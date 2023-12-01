package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.services.food.FoodFindService
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin
@RequestMapping(path = [RootPath.INGREDIENT])
@RestController
class FoodController( val foodFindService: FoodFindService) {

    private val logger = KotlinLogging.logger {}


    @CrossOrigin(origins = arrayOf("http://localhost:8080"))

    @GetMapping("")
    fun findAll(): ResponseEntity<MutableIterable<Ingredient>> {
        logger.info { "FoodController.findAll()" }
        return ResponseEntity.ok(foodFindService.findSeasonalFood());
    }

    @GetMapping("/{id}")
    fun findThisRecipe(@PathVariable("id") ingredientId: String): ResponseEntity<Ingredient> {
        return ResponseEntity.ok(foodFindService.findById(ingredientId));
    }
}