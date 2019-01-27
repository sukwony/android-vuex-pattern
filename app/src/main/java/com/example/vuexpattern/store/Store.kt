package com.example.vuexpattern.store

import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Store @Inject constructor(val state: State) {
    private val uiThread = Looper.getMainLooper().thread

    private val handler = object: Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val mutation = mutations.getValue(msg.what)

            Log.d("Store", mutation.type)

            mutation.handler(state, msg.obj)
        }
    }

    fun commit(type: Int, payload: Any) {
        if (uiThread == Thread.currentThread()) {
            mutations.getValue(type).handler(state, payload)
        } else {
            handler.obtainMessage(type, payload).apply {
                sendToTarget()
            }
        }
    }
}