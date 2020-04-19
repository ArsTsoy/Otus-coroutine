package kz.chocofamily.coroutinelesson.data.entities

import com.google.gson.annotations.SerializedName

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

data class CryptoCurrencyModel(
    @SerializedName("symbol")
    val symbol: String
) {

    @SerializedName("image")
    val imageUrl: String? = null

    @SerializedName("name")
    val name: String = ""

    @SerializedName("market_cap")
    val marketCap: Long = 0

    @SerializedName("current_price")
    val currentPrice = 0f
}