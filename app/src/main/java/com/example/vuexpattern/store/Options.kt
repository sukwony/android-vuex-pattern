package com.example.vuexpattern.store

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.example.vuexpattern.BR
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class State @Inject constructor(): BaseObservable() {
    @get:Bindable
    var count by bindable(0, BR.count)
}

val mutations = mapOf(
    MutationType.INCREMENT to Mutation("increment") { state: State, payload: Any ->
        val increment =  payload as Int
        state.count = state.count + increment
    },
    MutationType.CHANGE_STATE_1 to Mutation("changeState1") { state: State, payload: Any ->
    }
)
