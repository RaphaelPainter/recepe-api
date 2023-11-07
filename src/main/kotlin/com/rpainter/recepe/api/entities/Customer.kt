package com.rpainter.recepe.api.entities

import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.util.*


@Entity
data class Customer(@Id var id: String?, var name: String, var creation_date: Date)


