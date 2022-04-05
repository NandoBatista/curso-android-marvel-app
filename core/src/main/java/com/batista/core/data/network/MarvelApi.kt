package com.batista.core.data.network

import com.batista.core.data.network.response.DataWrapperResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface MarvelApi {

    @GET("characters")
    suspend fun getCharacters(
        @QueryMap
        //Mapeamento de Strings com chave e valor
        queries: Map<String, String>
    ): DataWrapperResponse
}