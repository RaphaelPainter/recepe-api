package com.rpainter.recepe.api.domain.aggregates.orders.cook

import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.OrderValidationException
import com.rpainter.recepe.api.domain.aggregates.ValidatedOrders.cook.CookCreationValidatedOrder
import com.rpainter.recepe.api.domain.aggregates.orders.IOrder
import com.rpainter.recepe.api.domain.model.Cook

class CookCreationOrder(): IOrder() {

    private lateinit var cook: Cook

    override fun validate(): CookCreationValidatedOrder {
        if(isValid()){
            return CookCreationValidatedOrder(this)
        }else{
            throw OrderValidationException("Problem while validating CookCreationOrder")
        }
    }

    override fun isValid():Boolean{
        return (!this.cook.name.equals(null))
    }

    fun setCook(cook: Cook){
        this.cook = cook
    }

    fun getCook():Cook{
        return this.cook
    }
}