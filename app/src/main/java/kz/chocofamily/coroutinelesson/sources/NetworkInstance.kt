package kz.chocofamily.coroutinelesson.sources

import retrofit2.Retrofit

object NetworkInstance {

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(Gson)
        .build()
}