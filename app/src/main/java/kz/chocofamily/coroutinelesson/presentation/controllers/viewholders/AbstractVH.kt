package kz.chocofamily.coroutinelesson.presentation.controllers.viewholders

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-10
 */

abstract class AbstractVH<Model>(
    parent: ViewGroup,
    @LayoutRes layoutResId: Int
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(layoutResId, parent, false)
) {

    //region abstract
    abstract fun bind(model: Model)
    //endregion

    //region Vars
    protected val context: Context = itemView.context
    //endregion

}