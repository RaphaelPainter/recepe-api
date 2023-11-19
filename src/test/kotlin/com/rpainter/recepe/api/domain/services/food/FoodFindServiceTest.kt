package com.rpainter.recepe.api.domain.services.food

import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.ports.cook.IFoodRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import java.util.*


class FoodFindServiceTest {

    @BeforeEach
    fun init_mocks() {
        MockitoAnnotations.initMocks(this)
    }

    @Mock
    var dao: IFoodRepository? = null

    @InjectMocks
    val foodFindService: FoodFindService? = null

    @Test
    @Throws(Exception::class)
    fun findSeasonalFoodShouldReturnCorrect() {
        //GIVEN
        val food: Ingredient = Ingredient("Banane", 1, 12)
        val expected = ArrayList<Ingredient>()
        expected.add(food)

        `when`(dao?.findAll()).thenReturn(expected)

        //WHEN
        val obtained: MutableIterable<Ingredient>? = foodFindService?.findSeasonalFood()

        //THEN
        Mockito.verify(dao, Mockito.times(1))?.findAll();
        Assertions.assertEquals(expected, obtained)
    }


    @Test
    @Throws(Exception::class)
    fun is_seasonal_test_1() {
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

    @Test
    @Throws(Exception::class)
    fun is_seasonal_test_2() {
        //GIVEN
        val startSeason = 3
        val currentMonth = 2
        val endSeason = 1

        val expected = false

        //WHEN
        val obtained = FoodFindService.isSeasonal(startSeason,currentMonth,endSeason)

        //THEN
        Assertions.assertEquals(expected, obtained)
    }

    @Test
    @Throws(Exception::class)
    fun is_seasonal_test_3() {
        //GIVEN
        val startSeason = 3
        val currentMonth = 5
        val endSeason = 1

        val expected = true

        //WHEN
        val obtained = FoodFindService.isSeasonal(startSeason,currentMonth,endSeason)

        //THEN
        Assertions.assertEquals(expected, obtained)
    }

    @Test
    @Throws(Exception::class)
    fun is_seasonal_test_4() {
        //GIVEN
        val startSeason = 3
        val currentMonth = 1
        val endSeason = 2

        val expected = true

        //WHEN
        val obtained = FoodFindService.isSeasonal(startSeason,currentMonth,endSeason)

        //THEN
        Assertions.assertEquals(expected, obtained)
    }

    @Test
    @Throws(Exception::class)
    fun is_seasonal_test_5() {
        //GIVEN
        val startSeason = 3
        val currentMonth = 3
        val endSeason = 2

        val expected = true

        //WHEN
        val obtained = FoodFindService.isSeasonal(startSeason,currentMonth,endSeason)

        //THEN
        Assertions.assertEquals(expected, obtained)
    }

    @Test
    @Throws(Exception::class)
    fun is_seasonal_test_6() {
        //GIVEN
        val startSeason = 3
        val currentMonth = 2
        val endSeason = 2

        val expected = true

        //WHEN
        val obtained = FoodFindService.isSeasonal(startSeason,currentMonth,endSeason)

        //THEN
        Assertions.assertEquals(expected, obtained)
    }
}