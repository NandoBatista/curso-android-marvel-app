package com.example.marvelapp.presentation.characters

import androidx.paging.PagingData
import com.batista.core.usecase.GetCharactersUseCase
import com.example.testing.MainCoroutineRule
import com.example.testing.model.CharacterFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException

//Quem vai executar nosso teste,nesse caso o Mockito
@RunWith(MockitoJUnitRunner::class)
class CharactersViewModelTest {

    //Serve para executar o código de Coroutines na mesma Thread principal utilizando o módulo de Testing
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    //Mockar o objeto/criar um objeto fake
    @Mock
    lateinit var getCharactersUseCase: GetCharactersUseCase

    private lateinit var charactersViewModel: CharactersViewModel

    private val charactersFactory = CharacterFactory()

    private val pagingDataCharacters = PagingData.from(
        listOf(
            charactersFactory.create(CharacterFactory.Hero.ThreeDMan),
            charactersFactory.create(CharacterFactory.Hero.ABomb),
        )
    )

    @ExperimentalCoroutinesApi
    //Antes de implementar os testes
    @Before
    fun setUp() {
        charactersViewModel = CharactersViewModel(getCharactersUseCase)
    }

    //Teste com a descrição do que será testado
    @ExperimentalCoroutinesApi
    @Test
    fun `should validate the paging data object values when calling charactersPagingData`() =
        runBlockingTest {
            //Quando eu receber qualquer valor da query ou pagingConfig...
            whenever(
                getCharactersUseCase.invoke(any())
                //Então ele espera um PagingData de Characters
            ).thenReturn(
                flowOf(
                    pagingDataCharacters
                )
            )


            //O resultado do teste
            val result = charactersViewModel.charactersPagingData("")

            assertEquals(1, result.count())

        }

    @ExperimentalCoroutinesApi
    @Test(expected = RuntimeException::class)
    fun `should throw an exception when the calling to the use case returns an exception`() =
        runBlockingTest {
            whenever(getCharactersUseCase.invoke(any()))
                .thenThrow(RuntimeException())

            charactersViewModel.charactersPagingData("")
        }
}