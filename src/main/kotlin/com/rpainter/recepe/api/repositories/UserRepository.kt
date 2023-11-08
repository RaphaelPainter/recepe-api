package com.rpainter.recepe.api.repositories

import com.rpainter.recepe.api.entities.ApiUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CrudRepository<ApiUser, String>
