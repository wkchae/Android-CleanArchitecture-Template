package com.hubtwork.clean_android.domain.junit5
/**
 * @author alenheo
 * @contacts hubtwork@gmail.com
 */
// JUnit 5 = JUnit Platform ( provide engine ) + Jupiter ( new features for 5 ) + Vintage ( runtime for 3 ~ 4 )
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
class BaseJUnitTest {
    private var testString: String? = null

    @BeforeEach
    fun setUpEach() {
        testString = "hello, JUnit5"
    }

    @Test
    @Order(1)
    fun `UnitTest With JUnit5` () {
        assert(testString != null)
        assert(testString == "hello, JUnit5")
        testString = "will check setup"
    }
    @Test
    @DisplayName("DisplayName Change Test")
    @Order(2)
    fun `UnitTest with JUnit5` () {
        assert(testString != null)
        assert(testString == "hello, JUnit5")
    }
    @ParameterizedTest
    @ValueSource(ints = [1000, 3000, 5000, 10000])
    fun `Parameter Test` (price: Int) {
        fun exposeAdditionalFee(price: Int): Int {
            val priceLimit = 4000
            val fee = 1000
            return if (price < priceLimit) price + fee
            else price
        }
        val result = exposeAdditionalFee(price)
        if (price < 4000) {
            assert(result == price + 1000)
        } else {
            assert(result == price)
        }
    }

}