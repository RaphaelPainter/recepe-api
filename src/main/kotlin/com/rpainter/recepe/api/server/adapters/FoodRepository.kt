package com.rpainter.recepe.api.server.adapters

import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.ports.cook.IFoodRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.util.*


@Repository
interface ItfFoodRepository : CrudRepository<Ingredient, String>


@Service
class FoodRepository( val repo: ItfFoodRepository) : IFoodRepository {

    override fun findAll(): MutableIterable<Ingredient> {
        return repo.findAll()
    }

    override fun findById(id: String): Optional<Ingredient> {
        return repo.findById(id)
    }
}