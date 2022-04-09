package com.batista.core.data

interface CharactersRemoteDataSource<T> {

    suspend fun fetchCharacters(queries: Map<String, String>): T
}