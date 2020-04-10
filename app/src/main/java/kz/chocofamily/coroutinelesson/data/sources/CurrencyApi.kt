package kz.chocofamily.coroutinelesson.data.sources

import kz.chocofamily.coroutinelesson.data.entities.CryptoCurrencyModel
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-09
 */

interface CurrencyApi {

    @GET("v3/coins/markets?sparkline=false")
    suspend fun getCryptoCurrencyList(
        @Query("vs_currency") chosenCurrency: String?,
        @Query("order") orderBy: String?,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): List<CryptoCurrencyModel>

}