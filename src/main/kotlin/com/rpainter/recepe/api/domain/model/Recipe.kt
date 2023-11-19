package com.rpainter.recepe.api.domain.model

import jakarta.persistence.*
import lombok.Builder
import java.util.*


@Builder
@Entity
data class Recipe(var name: String,
                  @ManyToOne var cooks_fk : Chef, var description : String,
                  @ManyToMany var ingredients: Set<Ingredient>?){

    @Id
    var id: UUID? = null

}

