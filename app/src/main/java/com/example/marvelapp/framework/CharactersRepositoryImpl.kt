package com.example.marvelapp.framework

import androidx.paging.PagingSource
import com.batista.core.data.CharactersRemoteDataSource
import com.batista.core.data.repository.CharactersRepository
import com.batista.core.domain.model.Character
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.framework.paging.CharactersPagingSource
import javax.inject.Inject

//Camada de abstração que contribui no isolamento da camada de acesso a dados com a camada de domínio
class CharactersRepositoryImpl @Inject constructor(
    private val remoteDataSource: CharactersRemoteDataSource<DataWrapperResponse>
): CharactersRepository {

    override fun getCharacters(query: String): PagingSource<Int, Character> {
        return CharactersPagingSource(remoteDataSource, query)
    }
}