package com.hubtwork.clean_android.data.network.api

import com.hubtwork.clean_android.data.network.service.PokeApiService
import com.hubtwork.clean_android.data.network.util.handle
import com.hubtwork.clean_android.domain.model.PokemonType
import com.hubtwork.clean_android.domain.util.io.DataSuccess
import com.hubtwork.clean_android.domain.util.io.onError
import com.hubtwork.clean_android.domain.util.io.onException
import com.hubtwork.clean_android.domain.util.io.onSuccess
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
@OptIn(ExperimentalCoroutinesApi::class)
@DisplayName("Pokemon API Test")
class PokeApiServiceTest: MockAPI<PokeApiService>() {
    private lateinit var service: PokeApiService
    @BeforeEach
    fun initService() { service = createService(PokeApiService::class.java) }

    @Test
    @DisplayName("Fetch PokemonList")
    fun t1() = runTest {
        enqueueResponse("pokemon_list.json")
        val response = handle { service.fetchPokemonList() }
            .onSuccess { data ->
                assertThat(data.size).isEqualTo(20)
                val firstData = data.getOrNull(0) ?: fail { "it must be not null"}
                assertThat(firstData.name).isEqualTo("bulbasaur")
                assertThat(firstData.image).isEqualTo("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png")
            }
            .onError { fail { "it must be success" } }
            .onException { fail { "it must be success" } }
        // check is successful response
        assertThat(response is DataSuccess).isEqualTo(true)
    }

    @Test
    @DisplayName("Get PokemonDetail")
    fun t2() = runTest {
        val target = "bulbasaur"
        enqueueResponse("pokemon_$target.json")
        val response = handle { service.getPokemonDetail(target) }
            .onSuccess { data ->
                println(data)
                assertThat(data.id).isEqualTo(1)
                assertThat(data.name).isEqualTo(target)
                assertThat(data.stats.speed.base).isEqualTo(45)
                assertThat(data.types.contains(PokemonType.Grass)).isEqualTo(true)
            }
            .onError { fail { "it must be success" } }
            .onException { fail { "it must be success" } }
        // check is successful response
        assertThat(response is DataSuccess).isEqualTo(true)
    }

}