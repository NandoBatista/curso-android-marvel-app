package com.example.marvelapp.framework.di

import com.batista.core.usecase.GetCharactersUseCase
import com.batista.core.usecase.GetCharactersUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface UseCaseModule {

    //Reconhece que tem alguém utilizando essa interface de UseCase
    @Binds
    fun bindCharactersUseCase(useCase: GetCharactersUseCaseImpl): GetCharactersUseCase
}