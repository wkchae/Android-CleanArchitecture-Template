package com.hubtwork.clean_android.data.repository

import com.hubtwork.clean_android.data.network.api.MockAPI
import com.hubtwork.clean_android.data.network.service.PokeApiService
import com.hubtwork.clean_android.data.network.service.PokemonClient
import com.hubtwork.clean_android.data.storage.PokemonStorage
import com.hubtwork.clean_android.data.storage.database.MockDB
import com.hubtwork.clean_android.data.storage.entity.mapper.toDomain
import com.hubtwork.clean_android.domain.repository.PokemonRepository
import com.hubtwork.clean_android.domain.util.io.onError
import com.hubtwork.clean_android.domain.util.io.onException
import com.hubtwork.clean_android.domain.util.io.onSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.fail
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(RobolectricTestRunner::class)
class PokemonRepositoryTest {
    inner class ClientFactory: MockAPI<PokeApiService>() {
        fun create(): PokemonClient {
            startMock()
            return PokemonClient(service = createService(PokeApiService::class.java))
        }
    }
    inner class MockStorage: MockDB() {
        fun create(): PokemonStorage {
            startMock()
            return PokemonStorage(database = db)
        }
        // for test method
        suspend fun getPokemon(groupId: Int) = db.thumbnailDao().getByGroupId(groupId_ = groupId).toDomain()

    }
    private lateinit var clientFactory: ClientFactory
    private lateinit var mockStorage: MockStorage
    private lateinit var repository: PokemonRepository

    @Before
    fun setup() {
        clientFactory = ClientFactory()
        mockStorage = MockStorage()
        repository = PokemonRepositoryImpl(
            service = clientFactory.create(),
            storage = mockStorage.create()
        )
    }

    @After
    fun clear() {
        clientFactory.endMock()
        mockStorage.endMock()
    }

    @Test
    fun `is Service init`() {
        assertThat(::repository.isInitialized).isEqualTo(true)
    }
    @Test
    fun `fetch pokemonList`() = runTest {
        val testGroupId = 3
        clientFactory.enqueueResponse("pokemon_list.json")
        repository.fetchPokemonList(testGroupId)
            .onSuccess { result ->
                assertThat(result).isNotEmpty
                val first = result.getOrNull(0) ?: fail("it must not be null !!!")
                assertThat(first.groupId).isEqualTo(testGroupId)
                val inStorage = mockStorage.getPokemon(testGroupId)
                assertThat(inStorage).isNotEmpty
                assertThat(result.toString()).isEqualTo(inStorage.toString())
                val notInStorage = mockStorage.getPokemon(0)
                assertThat(notInStorage).isEmpty()
            }
            .onError { fail("it must not be reached !!!") }
            .onException { fail("it must not be reached !!!") }

    }




}