package com.rpainter.recepe.api.server.adapters

import com.rpainter.recepe.api.domain.orders.cook.CookCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Chef
import com.rpainter.recepe.api.domain.ports.cook.ICookRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Repository
interface ItfCookRepository : CrudRepository<Chef, String>

@Service
class CookRepository( val repo: ItfCookRepository) : ICookRepository {

    override fun findAll(): MutableIterable<Chef> {
        return repo.findAll()
    }

    override fun save(cookCreationValidatedOrder: CookCreationValidatedOrder): Chef {
        return repo.save(
            cookCreationValidatedOrder.order.getCook()
        )
    }
}