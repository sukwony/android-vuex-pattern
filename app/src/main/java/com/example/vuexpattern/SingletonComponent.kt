package com.example.vuexpattern

import com.example.vuexpattern.store.Store
import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
interface SingletonComponent {
    fun store(): Store
}