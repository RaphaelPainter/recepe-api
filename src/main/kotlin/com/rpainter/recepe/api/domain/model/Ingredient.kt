package com.rpainter.recepe.api.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import lombok.Builder
import java.util.*


@Builder
@Entity
data class Ingredient(var name: String, var season_start : Int, var season_end : Int, var image: String){

    @Id
    var id: String? = null
}

