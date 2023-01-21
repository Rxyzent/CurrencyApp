package com.example.lesson45.helper

import android.graphics.Color

class ColorReporter {
    companion object {
        private val colors = arrayListOf<Int>(
            Color.parseColor("#A66CFF"),
            Color.parseColor("#9C9EFE"),
            Color.parseColor("#B1E1FF"),
            Color.parseColor("#AFB4FF"),
            Color.parseColor("#FFB3B3"),
            Color.parseColor("#FFDBA4"),
            Color.parseColor("#FFE9AE"),
            Color.parseColor("#C1EFFF"),
            Color.parseColor("#FFE6E6"),
            Color.parseColor("#F2D1D1"),
            Color.parseColor("#DAEAF1"),
            Color.parseColor("#C6DCE4"),
        )

        fun getColor(position:Int):Int{
            return colors[position % colors.size]
        }
    }
}