package kz.example.coroutinelesson.presentation.extensions

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-19
 */

internal fun Number.toStringByThousandSeparator(): String {
    return  try {
        String.format("%,d", this).replace(",", " ")
    } catch (e:NumberFormatException) {
        ""
    }
}