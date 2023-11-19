package com.rpainter.recepe.api.domain.ports.food

import com.rpainter.recepe.api.domain.model.Ingredient

interface IFoodFindService {
    fun findSeasonalFood(): MutableIterable<Ingredient>
}