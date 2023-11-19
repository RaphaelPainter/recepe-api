package com.rpainter.recepe.api.domain.ports.recipe

import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.orders.recipe.RecipeCreationOrder

interface IRecipeCreationService {
    fun save(recipe: Recipe): Recipe
}
