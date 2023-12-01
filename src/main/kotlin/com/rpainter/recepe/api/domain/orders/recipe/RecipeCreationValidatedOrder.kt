package com.rpainter.recepe.api.domain.orders.recipe

import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.orders.IValidatedOrder

class RecipeCreationValidatedOrder(order: RecipeCreationOrder) : IValidatedOrder(order){
    fun getRecipe(): Recipe {
        return (order as RecipeCreationOrder).getRecipe()
    }
    fun getFood(): MutableIterable<Ingredient> {
        return (order as RecipeCreationOrder).getTheFood()
    }
}