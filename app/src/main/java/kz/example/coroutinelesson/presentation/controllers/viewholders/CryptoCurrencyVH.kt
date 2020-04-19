package kz.example.coroutinelesson.presentation.controllers.viewholders

import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.vh_currency.view.*
import kz.example.coroutinelesson.R
import kz.example.coroutinelesson.data.entities.CryptoCurrencyModel

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
            Glide.with(context)
                .load(model.imageUrl)
                .into(ivCurrencyLogo)
            tvSymbol.text = model.symbol
            tvName.text = model.name
            tvPrice.text = model.currentPrice.toString()
            tvMarketCap.text = model.marketCap.toString()
        }
    }
    //endregion
}