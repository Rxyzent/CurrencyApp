package com.example.lesson45.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.lesson45.databinding.SecondListItemBinding
import com.example.lesson45.models.CurrencyResponse
import com.example.lesson45.models.CurrencyResponseItem

class SecondAdapter:BaseAdapter() {
    private lateinit var binding: SecondListItemBinding
    var data = CurrencyResponse()
    set(value) {
        field.addAll(value)
        notifyDataSetChanged()
    }

    override fun getCount(): Int = data.size

    override fun getItem(p0: Int): CurrencyResponseItem {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long = getItem(p0).id.toLong()

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val data = getItem(p0)
        binding = SecondListItemBinding.inflate(LayoutInflater.from(p2!!.context),p2,false)

        binding.dateText.text = data.Date
        binding.currency.text = data.Rate

        return binding.root
    }
}
