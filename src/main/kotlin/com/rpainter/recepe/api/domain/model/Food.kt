package com.rpainter.recepe.api.domain.model

import jakarta.persistence.Entity
import jakarta.persistence.Id
import lombok.Builder
import java.time.ZoneId
import java.util.*


@Builder
@Entity
data class Food(var name: String, var season_start : Int, var season_end : Int){

    @Id
    var id: UUID? = null



}

