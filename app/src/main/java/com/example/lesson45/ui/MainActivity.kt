package com.example.lesson45.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.lesson45.adapter.Adapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.blongho.country_data.World
import com.example.lesson45.databinding.ActivityMainBinding
import com.example.lesson45.models.CurrencyResponse
import com.example.lesson45.models.CurrencyResponseItem
import com.example.lesson45.network.CBUNetwork
import com.google.android.material.datepicker.MaterialDatePicker
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    private var currencyResponse: CurrencyResponse? = null

    private lateinit var binding: ActivityMainBinding

    private lateinit var selectedDateString: String

    private val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        World.init(this)
        val dataPicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Select date")
            .setSelection(MaterialDatePicker.thisMonthInUtcMilliseconds())
            .build()

        binding.listView.adapter = adapter

        loadData()

        binding.calendar.setOnClickListener {
           dataPicker.show(supportFragmentManager,"tag")

            dataPicker.addOnPositiveButtonClickListener {
                val simpleDateFormat = SimpleDateFormat("yyyy-MM-dd")
                selectedDateString = simpleDateFormat.format(it)
                dataPicker.dismiss()
                loadDateData(selectedDateString)
            }
        }

        adapter.listItemClick = {
            onListItemClick(it)
        }
    }

    private fun loadDateData(selectedDateString: String) {

        val call = CBUNetwork.getClient().getDateRate(selectedDateString)
        call.enqueue(object :Callback<CurrencyResponse>{
            override fun onResponse(
                call: Call<CurrencyResponse>,
                response: Response<CurrencyResponse>,
            ) {
                if (response.isSuccessful){
                    currencyResponse = response.body()

                    adapter.data = currencyResponse!!
                    binding.Home.text = currencyResponse!![0].Date
                }
            }

            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private fun onListItemClick(data : CurrencyResponseItem) {
        intent = Intent(this@MainActivity,secondActivity::class.java)
        intent.putExtra("currencyCcy",data.Ccy)
        intent.putExtra("date",data.Date)
        intent.putExtra("CcyNm",data.CcyNm_UZ)
        intent.putExtra("rate",data.Rate)
        startActivity(intent)
    }

    fun loadData() {
        val call = CBUNetwork.getClient().getCurrentRate()
        call.enqueue(object : Callback<CurrencyResponse> {
            override fun onResponse(
                call: Call<CurrencyResponse>,
                response: Response<CurrencyResponse>,
            ) {
                if(response.isSuccessful){
                    currencyResponse = response.body()

                    adapter.data = currencyResponse!!
                    //adapter.setData()

                }
            }

            override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}