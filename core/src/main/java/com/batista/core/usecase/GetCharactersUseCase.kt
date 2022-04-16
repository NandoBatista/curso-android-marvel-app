package com.batista.core.usecase

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.batista.core.data.repository.CharactersRepository
import com.batista.core.domain.model.Character
import com.batista.core.usecase.base.PagingUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

//UseCase faz a separação da camada de apresentação da camada de dados
class GetCharactersUseCase @Inject constructor(
    //Busca personagens da camada de repositório.
    private val charactersRepository: CharactersRepository
) : PagingUseCase<GetCharactersUseCase.GetCharactersParams, Character>() {

    //Regra de negócio da aplicação que trabalha com o Paging 3
    override fun createFlowObservable(params: GetCharactersParams): Flow<PagingData<Character>> {
        return Pager(config = params.pagingConfig) {
            charactersRepository.getCharacters(params.query)
        }.flow
    }

    data class GetCharactersParams(val query: String, val pagingConfig: PagingConfig)
}