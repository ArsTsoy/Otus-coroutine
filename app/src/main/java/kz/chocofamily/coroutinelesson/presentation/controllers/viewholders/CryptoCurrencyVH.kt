package kz.chocofamily.coroutinelesson.presentation.controllers.viewholders

import android.view.ViewGroup
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
        TODO("Not yet implemented")
    }
    //endregion
}