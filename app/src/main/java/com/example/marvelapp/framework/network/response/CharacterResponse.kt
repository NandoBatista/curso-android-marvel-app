package com.example.marvelapp.framework.network.response

import com.batista.core.domain.model.Character

data class CharacterResponse(
    val id: Int,
    val name: String,
    val thumbnail: ThumbnailResponse
)

//Convertendo a resposta de personagens em https
fun CharacterResponse.toCharacterModel(): Character {
    return Character(
        name = this.name,
        imageUrl = "${this.thumbnail.path}.${this.thumbnail.extension}"
            .replace("http", "https")
    )
}
