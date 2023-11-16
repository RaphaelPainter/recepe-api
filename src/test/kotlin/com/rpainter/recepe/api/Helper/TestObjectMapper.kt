package com.rpainter.recepe.api.Helper

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat


class TestObjectMapper {
    companion object{

        private var instance: ObjectMapper? =null

        fun getInstance():ObjectMapper? {
            if(instance == null){
                instance = ObjectMapper()
                val df = SimpleDateFormat("dd-MM-yyyy hh:mm")
                instance!!.setDateFormat(df);
                instance!!.registerModule(JavaTimeModule())
            }
            return instance
        }
    }
}