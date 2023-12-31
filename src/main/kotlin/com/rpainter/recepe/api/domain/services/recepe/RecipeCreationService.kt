package com.rpainter.recepe.api.domain.services.recepe

import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.orders.recipe.RecipeCreationOrder
import com.rpainter.recepe.api.domain.ports.recipe.IRecipeCreationService
import com.rpainter.recepe.api.domain.ports.recipe.IRecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeCreationService(val recipeRepository: IRecipeRepository): IRecipeCreationService {
    override fun save(recipe: Recipe): Recipe {

        val recipeCreationOrder : RecipeCreationOrder = RecipeCreationOrder()
        recipeCreationOrder.setRecipe(recipe)

        return recipeRepository.save(recipeCreationOrder.validate())
    }


}