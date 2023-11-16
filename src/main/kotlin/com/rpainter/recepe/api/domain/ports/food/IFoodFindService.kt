package com.rpainter.recepe.api.domain.ports.food

import com.rpainter.recepe.api.domain.model.Food

interface IFoodFindService {
    fun getSeasonalFood(): MutableIterable<Food>
}