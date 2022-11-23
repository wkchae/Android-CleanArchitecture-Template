package com.hubtwork.clean_android.presentation

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.hubtwork.clean_android.presentation.ui.SampleActivity
import de.mannodermaus.junit5.ActivityScenarioExtension
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.RegisterExtension


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleInstrumentedTest {

    @JvmField
    @RegisterExtension
    val scenarioExtension = ActivityScenarioExtension.launch<SampleActivity>()

    @DisplayName("")
    @Test
    fun test(scenario: ActivityScenario<SampleActivity>) {
        onView(withId(R.id.sample_tv)).check(matches(withText("sample")))

    }
}