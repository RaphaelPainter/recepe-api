package com.rpainter.recepe.api.domain.ports.food

import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.model.Recipe

interface IFoodFindService {
    fun findSeasonalFood(): MutableIterable<Ingredient>
    fun findById(ingredientId: String): Ingredient?
}