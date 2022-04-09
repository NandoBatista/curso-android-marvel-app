package com.batista.core.data

import androidx.paging.PagingSource
import com.batista.core.domain.model.Character

interface CharactersRepository {

    fun getCharacters(query: String): PagingSource<Int, Character>
}