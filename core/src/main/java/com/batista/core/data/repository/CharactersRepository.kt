package com.batista.core.data.repository

import androidx.paging.PagingSource
import com.batista.core.domain.model.Character

//Interface para implementação de Repository de personagens
interface CharactersRepository {

    fun getCharacters(query: String): PagingSource<Int, Character>
}