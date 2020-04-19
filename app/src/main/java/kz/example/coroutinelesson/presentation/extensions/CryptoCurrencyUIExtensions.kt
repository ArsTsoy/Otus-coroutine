package kz.example.coroutinelesson.presentation.extensions

import kz.example.coroutinelesson.data.entities.CryptoCurrencyModel

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

internal fun CryptoCurrencyModel.getUIMarketCap(): String {
    return this.marketCap.toStringByThousandSeparator()
}