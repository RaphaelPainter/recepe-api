package com.rpainter.recepe.api.domain.orders.recipe

import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.orders.IOrder
import com.rpainter.recepe.api.domain.orders.OrderValidationException

class RecipeCreationOrder(): IOrder() {

    private var food: MutableIterable<Ingredient>? = null

    private lateinit var recipe: Recipe

    override fun validate(): RecipeCreationValidatedOrder {
        if(isValid()){
            return RecipeCreationValidatedOrder(this)
        }else{
            throw OrderValidationException("Problem while validating RecipeCreationOrder")
        }
    }
    override fun isValid():Boolean{
        return (!this.recipe.equals(null)
                && this.food != null
                && this.food!!.count()>0)
    }

    fun setRecipe(recipe: Recipe){
        this.recipe = recipe
    }

    fun getRecipe(): Recipe {
        return this.recipe
    }

    fun setFood(food : MutableIterable<Ingredient>) {
        this.food = food
    }

    fun getTheFood(): MutableIterable<Ingredient>? {
        return this.food
    }
}