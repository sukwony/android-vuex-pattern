package com.example.vuexpattern.store

data class Mutation(val type: String, val handler: (State, Any) -> Unit)
