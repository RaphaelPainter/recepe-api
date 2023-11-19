package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.model.Ingredient


interface IFoodRepository {
    fun findAll(): MutableIterable<Ingredient>
}