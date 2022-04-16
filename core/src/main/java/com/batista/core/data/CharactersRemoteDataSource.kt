package com.batista.core.data

interface CharactersRemoteDataSource<T> {

    //Interface para implementação de DataSource dos personagens
    suspend fun fetchCharacters(queries: Map<String, String>): T
}