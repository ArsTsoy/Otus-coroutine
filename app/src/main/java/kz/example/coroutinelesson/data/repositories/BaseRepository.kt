package kz.example.coroutinelesson.data.repositories

import kz.example.coroutinelesson.data.entities.CryptoCurrencyModel
import kz.example.coroutinelesson.data.sources.NetworkInstance

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

private const val CRYPTOCURRENCIES_PER_PAGE = 100
private const val FIRST_PAGE = 1

class BaseRepository {

    suspend fun getCryptoCurrencyList(page: Int = FIRST_PAGE): List<CryptoCurrencyModel> {
        return NetworkInstance.currencyApi.getCryptoCurrencyList(
            Currency.USD.shortName,
            null,
            CRYPTOCURRENCIES_PER_PAGE,
            page
        )
    }

    sealed class Currency(val shortName: String) {
        object USD : Currency("usd")
    }
}