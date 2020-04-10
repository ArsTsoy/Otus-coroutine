package kz.chocofamily.coroutinelesson.data.sources

import kz.chocofamily.coroutinelesson.data.entities.ModelCryptoCurrency
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-09
 */

interface CurrencyApi {

    @GET("v3/coins/markets?sparkline=false")
    suspend fun getCurrencyList(
        @Query("vs_currency") chosenCurrency: String?,
        @Query("order") orderBy: String?,
        @Query("per_page") perPage: Int,
        @Query("page") page: Int
    ): ArrayList<ModelCryptoCurrency>

}