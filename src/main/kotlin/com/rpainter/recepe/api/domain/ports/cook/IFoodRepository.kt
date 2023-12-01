package com.rpainter.recepe.api.domain.ports.cook

import com.rpainter.recepe.api.domain.model.Ingredient
import java.util.*


interface IFoodRepository {
    fun findAll(): MutableIterable<Ingredient>
    fun findById(id: String): Optional<Ingredient>
}