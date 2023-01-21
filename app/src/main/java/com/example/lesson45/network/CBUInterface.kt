package com.example.lesson45.network


import com.example.lesson45.models.CurrencyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CBUInterface {
    //  https://cbu.uz/
    @GET("uz/arkhiv-kursov-valyut/json/")
    fun getCurrentRate(): Call<CurrencyResponse>

    @GET("uz/arkhiv-kursov-valyut/json/all/{date}/")
    fun getDateRate(
        @Path("date") dateString: String
    ):Call<CurrencyResponse>
    @GET("uz/arkhiv-kursov-valyut/json/{Ccy}/{date}/")
    fun getCountryData(
        @Path("Ccy") CcyString: String,
        @Path("date") dateString: String
    ):Call<CurrencyResponse>
}