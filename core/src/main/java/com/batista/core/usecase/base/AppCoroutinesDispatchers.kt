package com.batista.core.usecase.base

import kotlinx.coroutines.CoroutineDispatcher

//Quem precisar de um contexto de Coroutines é passado uma instância de AppCoroutinesDispatchers
data class AppCoroutinesDispatchers(
    val io: CoroutineDispatcher,
    val computation: CoroutineDispatcher,
    val main: CoroutineDispatcher
)
