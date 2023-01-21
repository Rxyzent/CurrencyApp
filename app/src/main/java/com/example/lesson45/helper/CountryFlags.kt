package com.example.lesson45.helper

class CountryFlags:ArrayList<CurrencyResponseImage>() {

    var data = ArrayList<CurrencyResponseImage>()
    set(value) {
        field.addAll(value)
    }



    fun getFlagById(id:Int):String{
        for(i in 0 until data.size){
            if(id==data[i].id){
                return data[i].imageUrl
            }
        }
        return ""
    }
}