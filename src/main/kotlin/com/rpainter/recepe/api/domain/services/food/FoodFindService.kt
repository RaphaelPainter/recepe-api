package com.rpainter.recepe.api.domain.services.food

import com.rpainter.recepe.api.domain.model.Ingredient
import com.rpainter.recepe.api.domain.model.Recipe
import com.rpainter.recepe.api.domain.ports.cook.IFoodRepository
import com.rpainter.recepe.api.domain.ports.food.IFoodFindService
import org.springframework.stereotype.Service
import java.time.ZoneId
import java.util.*

@Service
class FoodFindService(val foodRepository : IFoodRepository): IFoodFindService {

    override fun findSeasonalFood(): MutableIterable<Ingredient> {
        val date = Date()
        val localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val current_month = localDate.monthValue

        return getFoodRep().findAll().filter {
            isSeasonal(it.season_start, current_month, it.season_end)
        }.toMutableList()
    }

    override fun findById(ingredientId: String): Ingredient? {
        return foodRepository.findById(ingredientId).get()
    }

    fun getFoodRep():IFoodRepository{
        return foodRepository
    }

   companion object{
       fun isSeasonal(startSeason:Int, currentMonth:Int, endSeason: Int):Boolean{
           var end = endSeason
           var current = currentMonth
            if(startSeason > endSeason){
                if(currentMonth < startSeason){
                    current += NB_OF_MONTHS_PER_YEAR
                }
                end += NB_OF_MONTHS_PER_YEAR
            }
           return current in (startSeason) until end+1
       }

       const val NB_OF_MONTHS_PER_YEAR:Int = 12
   }
}