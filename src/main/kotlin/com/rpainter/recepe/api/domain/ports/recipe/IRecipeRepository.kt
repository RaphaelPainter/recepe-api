package com.rpainter.recepe.api.domain.ports.recipe

import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.orders.recipe.RecipeCreationOrder
import com.rpainter.recepe.api.domain.orders.recipe.RecipeCreationValidatedOrder

interface IRecipeRepository {
    fun findAll(): MutableIterable<Recipe>
    fun save(recipeCreationValidatedOrder: RecipeCreationValidatedOrder): Recipe
}