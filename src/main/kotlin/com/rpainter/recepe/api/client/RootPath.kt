package com.rpainter.recepe.api.client



class RootPath {
    companion object {

        const val ADMIN = "/admin"
        const val NONADMIN = "/nonadmin"

        const val USER =  "$ADMIN/users"

        const val AUTH=  "$NONADMIN/auth"
        const val COOK =  "$NONADMIN/cooks"
        const val INGREDIENT =  "$NONADMIN/ingredient"
        const val RECIPE =  "$NONADMIN/recipe"
    }
}