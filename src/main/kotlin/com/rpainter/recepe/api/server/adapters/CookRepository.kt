package com.rpainter.recepe.api.server.adapters

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.cook.CookCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Cook
import com.rpainter.recepe.api.domain.ports.cook.ICookRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service



@Repository
interface ItfCookRepository : CrudRepository<Cook, String>


@Service
class CookRepository( val repo: ItfCookRepository) : ICookRepository {

    override fun findAll(): MutableIterable<Cook> {
        return repo.findAll()
    }

    override fun save(cookCreationValidatedOrder: CookCreationValidatedOrder): Cook {
        return repo.save(
            cookCreationValidatedOrder.order.getCook()
        )
    }
}