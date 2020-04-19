package kz.chocofamily.coroutinelesson.presentation.extensions

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-04-19
 */


fun Number.toStringByThousandSeparators(): String {
    return try {
        String.format("%,d", this).replace(",", " ")
    } catch (e: NumberFormatException) {
        ""
    }
}