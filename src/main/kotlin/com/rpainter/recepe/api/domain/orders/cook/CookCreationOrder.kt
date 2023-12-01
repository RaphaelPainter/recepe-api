package com.rpainter.recepe.api.domain.orders.cook

import com.rpainter.recepe.api.domain.orders.OrderValidationException
import com.rpainter.recepe.api.domain.orders.IOrder
import com.rpainter.recepe.api.domain.model.Chef

class CookCreationOrder(): IOrder() {

    private lateinit var cook: Chef

    override fun validate(): CookCreationValidatedOrder {
        if(isValid()){
            return CookCreationValidatedOrder(this)
        }else{
            throw OrderValidationException("Problem while validating CookCreationOrder")
        }
    }

    override fun isValid():Boolean{
        return (!this.cook.equals(null))
    }

    fun setCook(cook: Chef){
        this.cook = cook
    }

    fun getCook():Chef{
        return this.cook
    }
}