package com.example.marvelapp.framework.di

import com.batista.core.data.CharactersRemoteDataSource
import com.batista.core.data.repository.CharactersRepository
import com.example.marvelapp.framework.CharactersRepositoryImpl
import com.example.marvelapp.framework.network.response.DataWrapperResponse
import com.example.marvelapp.framework.remote.RetrofitCharactersDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    //Injetando um repositório com o Dagger Hilt para depender uma interface e não uma implementação
    @Binds
    fun bindCharacterRepository(repository: CharactersRepositoryImpl): CharactersRepository

    @Binds
    fun bindRemoteDataSource(
        //Quando depender de um CharactersRemoteDataSource injetar um RetrofitCharactersDataSource
        //Porque quem depende de um RemoteDataSource vai depender uma interface e não uma implementação
        dataSource: RetrofitCharactersDataSource
    ): CharactersRemoteDataSource<DataWrapperResponse>
}