package com.hubtwork.clean_android.domain.on

import com.hubtwork.clean_android.domain.util.syntactic.on
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource
import org.assertj.core.api.Assertions.assertThat

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */

@DisplayName("On - Core test")
class OnLibraryTest {
    @Nested
    @DisplayName("On - Basic")
    inner class OnBasic {
        @DisplayName("condition ( expression )")
        @ParameterizedTest
        @ValueSource(strings = ["phoenix", "dragon", "willow"])
        @NullSource
        fun t2(wandBase: String?) {
            var canMakeWand: Boolean? = null
            on(
                condition = !wandBase.isNullOrEmpty(),
                doIf = { canMakeWand = true }
            )
            if (wandBase.isNullOrEmpty()) {
                assertThat(canMakeWand).isEqualTo(null)
            } else {
                assertThat(canMakeWand).isEqualTo(true)
            }
        }
        @DisplayName("condition ( lambda )")
        @ParameterizedTest
        @ValueSource(ints = [1, 3, 5, 7, 9])
        @NullSource
        fun t1(wandId: Int?) {
            var predict: Boolean? = null
            on(
                condition = { wandId?.rem(3) == 0 },
                doIf = { predict = true }
            )
            if (wandId != null && wandId % 3 == 0) {
                assertThat(predict).isEqualTo(true)
            } else {
                assertThat(predict).isEqualTo(null)
            }
        }

    }

}