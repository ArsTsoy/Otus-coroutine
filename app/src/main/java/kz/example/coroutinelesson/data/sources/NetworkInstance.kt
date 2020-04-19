package kz.example.coroutinelesson.data.sources

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object NetworkInstance {

    private const val BASE_URL = "https://api.coingecko.com/api/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val currencyApi: CurrencyApi by lazy {
        retrofit.create(
            CurrencyApi::class.java)
    }
}