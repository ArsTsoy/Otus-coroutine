package kz.chocofamily.coroutinelesson.presentation.controllers.viewholders

import android.view.ViewGroup
import kotlinx.android.synthetic.main.vh_currency.view.*
import kz.chocofamily.coroutinelesson.R
import kz.chocofamily.coroutinelesson.data.entities.CryptoCurrencyModel

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

class CryptoCurrencyVH(
    parent: ViewGroup
) : AbstractVH<CryptoCurrencyModel>(
    parent,
    R.layout.vh_currency
) {
    //region Overridden Methods
    override fun bind(model: CryptoCurrencyModel) {
        with(itemView) {
            //TODO: заменить на UIExtensions
            tvSymbol.text = model.symbol
            tvName.text = model.name
            tvPrice.text = model.currentPrice.toString()
            tvMarketCap.text = model.marketCap.toString()
        }
    }
    //endregion
}