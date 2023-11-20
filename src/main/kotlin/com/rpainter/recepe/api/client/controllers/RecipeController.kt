package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.services.recepe.RecipeCreationService
import com.rpainter.recepe.api.domain.services.user.UserCreationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RequestMapping(path = [RootPath.RECIPE])
@RestController
class RecipeController(val recipeCreationService: RecipeCreationService) {
    @PostMapping()
    fun create(@RequestBody recipe: Recipe): ResponseEntity<Recipe> {
        return ResponseEntity.ok(recipeCreationService.save(recipe));
    }
}