package kz.chocofamily.coroutinelesson.presentation.controllers.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kz.chocofamily.coroutinelesson.data.entities.CryptoCurrencyModel
import kz.chocofamily.coroutinelesson.presentation.controllers.viewholders.CryptoCurrencyVH

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

class CryptoCurrencyListRVAdapter : RecyclerView.Adapter<CryptoCurrencyVH>() {

    //region Vars
    private val items: ArrayList<CryptoCurrencyModel> = ArrayList()
    //endregion

    //region Overridden Methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CryptoCurrencyVH {
        return CryptoCurrencyVH(parent)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CryptoCurrencyVH, position: Int) {
        holder.bind(items[position])
    }
    //endregion

    fun refreshCryptoCurrencies(newCryptoCurrencies: List<CryptoCurrencyModel>) {
        items.clear()
        items.addAll(newCryptoCurrencies)
        notifyDataSetChanged()
    }

}