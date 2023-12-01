package com.rpainter.recepe.api.client.controllers

import com.rpainter.recepe.api.client.RootPath
import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.services.recepe.RecipeCreationService
import com.rpainter.recepe.api.domain.services.recepe.RecipeFindService
import com.rpainter.recepe.api.domain.services.user.UserCreationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RequestMapping(path = [RootPath.RECIPE])
@RestController
class RecipeController(val recipeCreationService: RecipeCreationService, val recipeFindService: RecipeFindService) {
    @PostMapping()
    fun create(@RequestBody recipe: Recipe): ResponseEntity<Recipe> {
        return ResponseEntity.ok(recipeCreationService.save(recipe));
    }

    @GetMapping()
    fun findAllRecipes(): ResponseEntity<MutableIterable<Recipe>> {
        return ResponseEntity.ok(recipeFindService.findAll());
    }

    @GetMapping("/{id}")
    fun findThisRecipe(@PathVariable("id") ingredientId: String): ResponseEntity<Recipe> {
        return ResponseEntity.ok(recipeFindService.findById(ingredientId));
    }

    @GetMapping("/withIngredient/{id}")
    fun findRecipesWithThisIngredient(@PathVariable("id") ingredientId: String): ResponseEntity<MutableIterable<Recipe>> {
        return ResponseEntity.ok(recipeFindService.findRecipesWithThisIngredient(ingredientId));
    }
}