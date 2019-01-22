package com.example.vuexpattern.store

import android.arch.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.properties.Delegates

@Singleton
class State @Inject constructor() {
    val countLiveData: MutableLiveData<Int> = MutableLiveData()
    var count: Int by Delegates.observable(-1) { _, _, new ->
        countLiveData.value = new
    }

    init {
        count = 0
    }
}

val mutations = mapOf(
    MutationType.INCREMENT to Mutation("increment") { state: State, payload: Any ->
        val increment =  payload as Int
        state.count += increment
    },
    MutationType.CHANGE_STATE_1 to Mutation("changeState1") { state: State, payload: Any ->
    }
)
