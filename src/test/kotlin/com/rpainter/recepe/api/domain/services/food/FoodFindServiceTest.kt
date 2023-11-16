package com.rpainter.recepe.api.domain.services.food

import com.rpainter.recepe.api.domain.model.Account
import com.rpainter.recepe.api.domain.model.Cook
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

class FoodFindServiceTest {

    @Test
    @Throws(Exception::class)
    fun findAllCookShouldReturnAllCooks() {
        //GIVEN
        val startSeason = 1
        val currentMonth = 2
        val endSeason = 3

        val expected = true

        //WHEN
        val obtained = FoodFindService.isSeasonal(startSeason,currentMonth,endSeason)

        //THEN
        Assertions.assertEquals(expected, obtained)
    }
}