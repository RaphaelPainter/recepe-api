package com.rpainter.recepe.api.server.adapters

import com.rpainter.recepe.api.domain.orders.admin.AdminCreationValidatedOrder
import com.rpainter.recepe.api.domain.orders.user.UserCreationValidatedOrder
import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.ports.user.IUserRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service


@Repository
interface ItfUserRepository : CrudRepository<Account, String>


@Service
class UserRepository( val repo: ItfUserRepository) : IUserRepository {

    override fun findAll(): MutableIterable<Account> {
        return repo.findAll()
    }

    override fun save(userCreationValidatedOrder: UserCreationValidatedOrder): Account {
        return repo.save(
            userCreationValidatedOrder.getUser()
        )
    }

    override fun save(adminCreationValidatedOrder: AdminCreationValidatedOrder): Account {
            return repo.save(
                adminCreationValidatedOrder.order.getUser()
            )
    }
}