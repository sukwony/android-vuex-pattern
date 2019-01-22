package com.example.vuexpattern

import android.arch.lifecycle.ViewModel
import com.example.vuexpattern.store.MutationType

class MainViewModel: ViewModel() {
    private val store = Dagger.component.store()

    val count = store.state.countLiveData

    fun increment() {
        store.commit(MutationType.INCREMENT, 2)
    }
}
