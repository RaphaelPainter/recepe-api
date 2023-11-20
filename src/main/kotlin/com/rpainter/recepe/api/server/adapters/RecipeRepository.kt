package com.rpainter.recepe.api.server.adapters

import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.orders.recipe.RecipeCreationOrder
import com.rpainter.recepe.api.domain.orders.recipe.RecipeCreationValidatedOrder
import com.rpainter.recepe.api.domain.ports.recipe.IRecipeRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Repository
interface ItfRecipeRepository : CrudRepository<Recipe, String>


@Service
class RecipeRepository( val repo: ItfRecipeRepository) : IRecipeRepository {

    override fun findAll(): MutableIterable<Recipe> {
        return repo.findAll()
    }

    override fun save(recipeCreationValidatedOrder: RecipeCreationValidatedOrder): Recipe {
        return repo.save(
                recipeCreationValidatedOrder.getRecipe()
        )
    }
}