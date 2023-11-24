package com.rpainter.recepe.api.domain.services.recepe

import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.ports.recipe.IRecipeCreationService
import com.rpainter.recepe.api.domain.ports.recipe.IRecipeFindService
import com.rpainter.recepe.api.domain.ports.recipe.IRecipeRepository
import org.apache.kafka.common.protocol.types.ArrayOf
import org.springframework.stereotype.Service
import java.util.*

@Service
class RecipeFindService (val recipeRepository: IRecipeRepository): IRecipeFindService {
    override fun findRecipesWithThisIngredient(ingredientId: String): MutableIterable<Recipe>? {
        return recipeRepository.findAll().filter {
            it.ingredients?.map{
                it.id
            }?.toMutableList()!!.contains(ingredientId)
        }.toMutableList()
    }

    override fun findAll(): MutableIterable<Recipe>? {
        return recipeRepository.findAll()
    }

    override fun findById(id: String): Recipe {
        return recipeRepository.findById(id).get()
    }
}