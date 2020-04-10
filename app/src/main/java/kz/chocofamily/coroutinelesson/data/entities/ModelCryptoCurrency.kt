package kz.chocofamily.coroutinelesson.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

data class ModelCryptoCurrency(
    @SerializedName("symbol")
    private val symbol: String
) {

    @SerializedName("image")
    val imageUrl: String? = null

    @SerializedName("name")
    private val name: String = ""

    @SerializedName("market_cap")
    private val marketCap: Long = 0

    @SerializedName("current_price")
    private val currentPrice = 0f
}