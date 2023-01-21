package com.example.lesson45.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CBUNetwork {


    companion object {
        private fun getRetrofit():Retrofit{
            return Retrofit.Builder()
                .baseUrl("https://cbu.uz/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        fun getClient():CBUInterface{
            return getRetrofit().create(CBUInterface::class.java)
        }
    }


}