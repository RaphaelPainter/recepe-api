package com.rpainter.recepe.api.domain.ports.recipe

import com.rpainter.recepe.api.domain.model.Recipe
import java.util.*

interface IRecipeFindService {

    fun findAll(): MutableIterable<Recipe>?
    fun findById(id: String): Recipe
    fun findRecipesWithThisIngredient(ingredientId: String): MutableIterable<Recipe>?
}