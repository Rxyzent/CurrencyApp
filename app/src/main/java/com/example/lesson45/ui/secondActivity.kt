package com.example.lesson45.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import com.example.lesson45.adapter.SecondAdapter
import com.example.lesson45.databinding.ActivitySecondBinding
import com.example.lesson45.models.CurrencyResponse
import com.example.lesson45.network.CBUNetwork
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.random.Random

class secondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    private var currencyResponse: CurrencyResponse? = null
    private val adapter = SecondAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val currencyCcy = intent.getStringExtra("currencyCcy")
        val dateString = intent.getStringExtra("date")
        val CcyNmUz  = intent.getStringExtra("CcyNm")
        val Rate = intent.getStringExtra("rate")!!.toDouble()


        val year = dateString!!.substring(6).toLong()
        val month = dateString!!.substring(3, 5).toLong()

        binding.text1.text = CcyNmUz
        binding.text2.text = "O'zbek so'mi"
        binding.EditText1.addTextChangedListener {
           var num = 0
            it?.let {
                 num = it.toString().toInt()
            }

            binding.EditText2.text = (num*Rate).toString()
        }
        binding.back.setOnClickListener {
            finish()
        }

        var month1 = month
        var year1 = year

        for (i in 1 until 10) {
            val day = Random.nextInt(1, 29)
            if (month - i >= 1) {
                month1 = month - i
            } else {
                month1 = month - i + 12
                year1 = year - 1
            }

            val dateString = String.format("%04d-%02d-%02d", year1, month1, day)
            Log.d("dateStr", "loadData: $dateString")

            loadData(currencyCcy!!, dateString)

        }
        binding.listView.adapter = adapter

    }

    private fun loadData(Ccy: String, dateString:String) {


            val call = CBUNetwork.getClient().getCountryData(Ccy, dateString)
            call.enqueue(object : Callback<CurrencyResponse> {
                override fun onResponse(
                    call: Call<CurrencyResponse>,
                    response: Response<CurrencyResponse>,
                ) {
                    if(response.isSuccessful){
                        currencyResponse = response!!.body()
                        adapter.data = currencyResponse!!
                        Log.d("CurrencyData", "onResponse: $currencyResponse")
                    }
                }

                override fun onFailure(call: Call<CurrencyResponse>, t: Throwable) {
                    Log.d("Fail", "onFailure: ${t.message}")
                }

            })

    }
}