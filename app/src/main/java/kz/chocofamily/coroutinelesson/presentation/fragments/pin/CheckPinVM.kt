package kz.chocofamily.coroutinelesson.presentation.fragments.pin

import kz.chocofamily.coroutinelesson.presentation.SharedVM

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 2020-05-28
 */

class CheckPinVM: SharedVM<CheckPinVM.PinCheckState>() {

    sealed class PinCheckState {
        object Success: PinCheckState()
        object Fail: PinCheckState()
    }

}