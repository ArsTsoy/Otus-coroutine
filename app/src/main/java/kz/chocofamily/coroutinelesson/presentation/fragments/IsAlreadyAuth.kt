package kz.chocofamily.coroutinelesson.presentation.fragments

import kz.chocofamily.coroutinelesson.presentation.SharedVM

/**
 * Created by Arslan Tsoy <t.me/arslantsoy> on 5/29/20
 */

class IsAlreadyAuth : SharedVM<IsAlreadyAuth.AuthState> () {

    sealed class AuthState {
        object Success: AuthState()
        object Failed: AuthState()
    }
}