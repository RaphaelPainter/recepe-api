package com.rpainter.recepe.api.domain.services.food

import com.rpainter.recepe.api.domain.model.Food
import com.rpainter.recepe.api.domain.ports.cook.IFoodRepository
import com.rpainter.recepe.api.domain.ports.food.IFoodFindService
import org.springframework.stereotype.Service
import java.time.ZoneId
import java.util.*

@Service
class FoodFindService(val foodRepository : IFoodRepository): IFoodFindService {
    override fun getSeasonalFood(): MutableIterable<Food> {
        val date = Date()
        val localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val current_month = localDate.monthValue

        return foodRepository.findAll().filter {
            it.season_start > 1
                    && it.season_end > 1
        }.toMutableList()
    }

   companion object{
       fun isSeasonal(startSeason:Int, current_month:Int, endSeason: Int):Boolean{

           return true
       }
   }
}