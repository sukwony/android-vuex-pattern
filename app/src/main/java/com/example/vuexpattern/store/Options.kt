package com.example.vuexpattern.store

import android.arch.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class State @Inject constructor() {
    val count: MutableLiveData<Int> = MutableLiveData()
    val state1: MutableLiveData<Int> = MutableLiveData()
}

@Singleton
class Mutations @Inject constructor() {
    companion object {
        const val INCREMENT = 0
        const val CHANGE_STATE_1 = 1
    }

    val entries = mapOf(
        INCREMENT to Mutation("increment") { state: State, payload: Any ->
            val increment =  payload as Int
            state.count.value = state.count.value ?: 0 + increment
        },
        CHANGE_STATE_1 to Mutation("changeState1") { state: State, payload: Any ->
        }
    )
}
