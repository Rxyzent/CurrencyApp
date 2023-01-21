package com.example.lesson45.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.core.content.ContextCompat
import coil.load
import com.blongho.country_data.World
import com.example.lesson45.R
import com.example.lesson45.databinding.ListItemBinding
import com.example.lesson45.helper.CountryFlags
import com.example.lesson45.helper.CurrencyResponseImage
import com.example.lesson45.models.CurrencyResponse
import com.example.lesson45.models.CurrencyResponseItem
import java.util.*
import kotlin.collections.ArrayList

class Adapter : BaseAdapter() {

    private lateinit var binding: ListItemBinding

    var listItemClick: ((currencyResponce: CurrencyResponseItem) -> Unit)? = null

    var data = CurrencyResponse()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun getCount(): Int = data.size
    override fun getItem(p0: Int): CurrencyResponseItem {
        return data[p0]
    }

    override fun getItemId(p0: Int): Long {
        return getItem(p0).id.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {

        var image = CountryFlags()
        loadFlags(image)
        val data: CurrencyResponseItem = getItem(p0)
        binding = ListItemBinding.inflate(LayoutInflater.from(p2!!.context), p2, false)

        binding.text1.text = data.Ccy
        binding.text2.text = data.Rate.plus("...")
        binding.date.text = data.Date

        binding.image.load(image.getFlagById(data.id))


        if (data.Diff.get(0) == '-') {
            binding.diff.text = data.Diff
            binding.diff.setTextColor(ContextCompat.getColor(p2!!.context, R.color.red))
        } else {
            binding.diff.text = "+".plus(data.Diff)
            binding.diff.setTextColor(ContextCompat.getColor(p2!!.context, R.color.green))
        }

        binding.root.setOnClickListener {
            listItemClick?.invoke(data)
        }

        return binding.root
    }

    private fun loadFlags(image: CountryFlags) {
        var flags = ArrayList<CurrencyResponseImage>()
        flags.addAll(
            arrayListOf<CurrencyResponseImage>(
                CurrencyResponseImage(69, "https://upload.wikimedia.org/wikipedia/en/thumb/a/a4/Flag_of_the_United_States.svg/1200px-Flag_of_the_United_States.svg.png"),
                CurrencyResponseImage(21, "https://media.istockphoto.com/vectors/flag-of-european-union-vector-id1136371403?k=20&m=1136371403&s=612x612&w=0&h=MrvZuR9VMZ6JdNFfTuyhye4KwcWMJ1URT2M_ZDwYkuo="),
                CurrencyResponseImage(57, "https://upload.wikimedia.org/wikipedia/en/thumb/f/f3/Flag_of_Russia.svg/640px-Flag_of_Russia.svg.png"),
                CurrencyResponseImage(22, "https://upload.wikimedia.org/wikipedia/en/thumb/a/ae/Flag_of_the_United_Kingdom.svg/1200px-Flag_of_the_United_Kingdom.svg.png"),
                CurrencyResponseImage(33, "https://upload.wikimedia.org/wikipedia/en/thumb/9/9e/Flag_of_Japan.svg/1200px-Flag_of_Japan.svg.png"),
                CurrencyResponseImage(6, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/74/Flag_of_Azerbaijan_%283-2%29.svg/1200px-Flag_of_Azerbaijan_%283-2%29.svg.png"),
                CurrencyResponseImage(7, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Flag_of_Bangladesh.svg/1200px-Flag_of_Bangladesh.svg.png"),
                CurrencyResponseImage(8,"https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Bulgaria.svg/1200px-Flag_of_Bulgaria.svg.png"),
                CurrencyResponseImage(9, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Flag_of_Bahrain_%28bordered%29.svg/2560px-Flag_of_Bahrain_%28bordered%29.svg.png"),
                CurrencyResponseImage(10, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/de/Flag_of_Brunei_%283-2%29.svg/2560px-Flag_of_Brunei_%283-2%29.svg.png"),
                CurrencyResponseImage(11, "https://upload.wikimedia.org/wikipedia/en/thumb/0/05/Flag_of_Brazil.svg/640px-Flag_of_Brazil.svg.png"),
                CurrencyResponseImage(12, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/85/Flag_of_Belarus.svg/2560px-Flag_of_Belarus.svg.png"),
                CurrencyResponseImage(13, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/255px-Flag_of_Canada_%28Pantone%29.svg.png"),
                CurrencyResponseImage(14, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Flag_of_Switzerland.svg/2048px-Flag_of_Switzerland.svg.png"),
                CurrencyResponseImage(15, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/2560px-Flag_of_the_People%27s_Republic_of_China.svg.png"),
                CurrencyResponseImage(16, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/28/Flag_of_Puerto_Rico.svg/220px-Flag_of_Puerto_Rico.svg.png"),
                CurrencyResponseImage(17, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_Czech_Republic.svg/2560px-Flag_of_the_Czech_Republic.svg.png"),
                CurrencyResponseImage(18, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Flag_of_Denmark.svg/1280px-Flag_of_Denmark.svg.png"),
                CurrencyResponseImage(19, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/77/Flag_of_Algeria.svg/1200px-Flag_of_Algeria.svg.png"),
                CurrencyResponseImage(20, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Egypt.svg/220px-Flag_of_Egypt.svg.png"),
                CurrencyResponseImage(2, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Flag_of_Afghanistan_%281929%E2%80%931931%29.svg/2560px-Flag_of_Afghanistan_%281929%E2%80%931931%29.svg.png"),
                CurrencyResponseImage(4, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/2560px-Flag_of_Argentina.svg.png"),
                CurrencyResponseImage(23, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a2/Flag_of_Kingdom_of_Georgia.svg/2560px-Flag_of_Kingdom_of_Georgia.svg.png"),
                CurrencyResponseImage(24, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5b/Flag_of_Hong_Kong.svg/1280px-Flag_of_Hong_Kong.svg.png"),
                CurrencyResponseImage(25, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c1/Flag_of_Hungary.svg/2560px-Flag_of_Hungary.svg.png"),
                CurrencyResponseImage(26, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9f/Flag_of_Indonesia.svg/1280px-Flag_of_Indonesia.svg.png"),
                CurrencyResponseImage(27, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Flag_of_Israel.svg/640px-Flag_of_Israel.svg.png"),
                CurrencyResponseImage(28, "https://upload.wikimedia.org/wikipedia/en/thumb/4/41/Flag_of_India.svg/1200px-Flag_of_India.svg.png"),
                CurrencyResponseImage(29, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Flag_of_Iraq.svg/255px-Flag_of_Iraq.svg.png"),
                CurrencyResponseImage(30, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ca/Flag_of_Iran.svg/630px-Flag_of_Iran.svg.png"),
                CurrencyResponseImage(31, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Flag_of_Iceland.svg/2560px-Flag_of_Iceland.svg.png"),
                CurrencyResponseImage(32, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c0/Flag_of_Jordan.svg/2560px-Flag_of_Jordan.svg.png"),
                CurrencyResponseImage(5, "https://cdn5.vectorstock.com/i/1000x1000/71/54/australian-national-flag-with-official-colors-vector-29197154.jpg"),
                CurrencyResponseImage(34, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c7/Flag_of_Kyrgyzstan.svg/300px-Flag_of_Kyrgyzstan.svg.png"),
                CurrencyResponseImage(35, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_Cambodia.svg/1200px-Flag_of_Cambodia.svg.png"),
                CurrencyResponseImage(36, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Flag_of_North_Korea.svg/800px-Flag_of_North_Korea.svg.png?20111024221023"),
                CurrencyResponseImage(37, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/aa/Flag_of_Kuwait.svg/1280px-Flag_of_Kuwait.svg.png"),
                CurrencyResponseImage(38, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d3/Flag_of_Kazakhstan.svg/1024px-Flag_of_Kazakhstan.svg.png"),
                CurrencyResponseImage(39, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/56/Flag_of_Laos.svg/2560px-Flag_of_Laos.svg.png"),
                CurrencyResponseImage(40, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/59/Flag_of_Lebanon.svg/2560px-Flag_of_Lebanon.svg.png"),
                CurrencyResponseImage(41, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/05/Flag_of_Libya.svg/800px-Flag_of_Libya.svg.png?20150519211827"),
                CurrencyResponseImage(42, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/2c/Flag_of_Morocco.svg/2560px-Flag_of_Morocco.svg.png"),
                CurrencyResponseImage(43, "https://upload.wikimedia.org/wikipedia/commons/8/8e/Moldova_flag_large-02.png"),
                CurrencyResponseImage(44, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/8c/Flag_of_Myanmar.svg/2560px-Flag_of_Myanmar.svg.png"),
                CurrencyResponseImage(45, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Flag_of_Mongolia.svg/1280px-Flag_of_Mongolia.svg.png"),
                CurrencyResponseImage(46, "https://upload.wikimedia.org/wikipedia/commons/1/17/Flag_of_Mexico.png"),
                CurrencyResponseImage(47, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Flag_of_Malaysia_%283-2%29.svg/2100px-Flag_of_Malaysia_%283-2%29.svg.png"),
                CurrencyResponseImage(48, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Norway.svg/2560px-Flag_of_Norway.svg.png"),
                CurrencyResponseImage(49, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_New_Zealand.svg/2560px-Flag_of_New_Zealand.svg.png"),
                CurrencyResponseImage(50, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9c/Flag_of_Oman_%283-2%29.svg/2560px-Flag_of_Oman_%283-2%29.svg.png"),
                CurrencyResponseImage(51, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c8/Flag_of_the_Philippines_%281919%E2%80%931936%29.svg/2560px-Flag_of_the_Philippines_%281919%E2%80%931936%29.svg.png"),
                CurrencyResponseImage(52, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Flag_of_Pakistan.png/640px-Flag_of_Pakistan.png"),
                CurrencyResponseImage(53, "https://upload.wikimedia.org/wikipedia/en/thumb/1/12/Flag_of_Poland.svg/1200px-Flag_of_Poland.svg.png"),
                CurrencyResponseImage(54, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Flag_of_Qatar_%283-2%29.svg/1024px-Flag_of_Qatar_%283-2%29.svg.png"),
                CurrencyResponseImage(55, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Flag_of_Romania.svg/2560px-Flag_of_Romania.svg.png"),
                CurrencyResponseImage(56, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Flag_of_Serbia.svg/2560px-Flag_of_Serbia.svg.png"),
                CurrencyResponseImage(3, "https://cdn.britannica.com/11/4711-004-1504C169/Flag-Armenia.jpg"),
                CurrencyResponseImage(58, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0d/Flag_of_Saudi_Arabia.svg/2000px-Flag_of_Saudi_Arabia.svg.png"),
                CurrencyResponseImage(59, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/01/Flag_of_Sudan.svg/2560px-Flag_of_Sudan.svg.png"),
                CurrencyResponseImage(60, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4c/Flag_of_Sweden.svg/2560px-Flag_of_Sweden.svg.png"),
                CurrencyResponseImage(61, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/48/Flag_of_Singapore.svg/1200px-Flag_of_Singapore.svg.png"),
                CurrencyResponseImage(62, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Flag_of_Syria.svg/2560px-Flag_of_Syria.svg.png"),
                CurrencyResponseImage(63, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/6b/Flag_of_Thailand_%28non-standard_colours%29.svg/1024px-Flag_of_Thailand_%28non-standard_colours%29.svg.png"),
                CurrencyResponseImage(64, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/95/Flag_of_Tajikistan_%283-2%29.svg/1200px-Flag_of_Tajikistan_%283-2%29.svg.png"),
                CurrencyResponseImage(65, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1b/Flag_of_Turkmenistan.svg/2000px-Flag_of_Turkmenistan.svg.png"),
                CurrencyResponseImage(66, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/ce/Flag_of_Tunisia.svg/2560px-Flag_of_Tunisia.svg.png"),
                CurrencyResponseImage(67, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b4/Flag_of_Turkey.svg/800px-Flag_of_Turkey.svg.png?20210808085121"),
                CurrencyResponseImage(68, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/49/Flag_of_Ukraine.svg/800px-Flag_of_Ukraine.svg.png?20100406171642"),
                CurrencyResponseImage(1, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/255px-Flag_of_the_United_Arab_Emirates.svg.png"),
                CurrencyResponseImage(70, "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fe/Flag_of_Uruguay.svg/2560px-Flag_of_Uruguay.svg.png"),
                CurrencyResponseImage(71, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/06/Flag_of_Venezuela.svg/1280px-Flag_of_Venezuela.svg.png"),
                CurrencyResponseImage(72, "https://upload.wikimedia.org/wikipedia/commons/thumb/2/21/Flag_of_Vietnam.svg/2560px-Flag_of_Vietnam.svg.png"),
                CurrencyResponseImage(73, "https://kiffmeister.files.wordpress.com/2022/07/imf-logo.jpg?w=656&h=300&crop=1"),
                CurrencyResponseImage(74, "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Flag_of_Yemen.svg/1280px-Flag_of_Yemen.svg.png"),
                CurrencyResponseImage(75, "https://upload.wikimedia.org/wikipedia/commons/thumb/0/09/Flag_of_South_Korea.svg/1280px-Flag_of_South_Korea.svg.png")
            )
        )
        image.data = flags
       }
}