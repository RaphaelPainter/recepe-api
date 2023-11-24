package com.rpainter.recepe.api.domain.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import jakarta.persistence.*
import lombok.Builder
import java.util.*


@Builder
@Entity
data class Recipe(var name: String,
                  @ManyToOne var cooks_fk : Chef, var description : String,
                  @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
                  @JoinTable(name = "recipe_ingredient",
                      joinColumns = [JoinColumn(name = "recipe_id", referencedColumnName = "id")],
                      inverseJoinColumns = [JoinColumn(name = "ingredient_id", referencedColumnName = "id")])
                  @JsonIgnoreProperties("routes")
                  var ingredients: List<Ingredient> = mutableListOf(),
                  var image: String){

    @Id
    var id: String? = null
}