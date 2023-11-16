package com.rpainter.recepe.api.server.adapters

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.admin.AdminCreationValidatedOrder
import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.user.UserCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Food
import com.rpainter.recepe.api.domain.ports.cook.IFoodRepository
import com.rpainter.recepe.api.domain.ports.user.IUserRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Repository
interface ItfFoodRepository : CrudRepository<Food, String>


@Service
class FoodRepository( val repo: ItfFoodRepository) : IFoodRepository {

    override fun findAll(): MutableIterable<Food> {
        return repo.findAll()
    }
}