package com.gotoandplaynow.three

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class DemoInstrumentedTest {

    // declare the first activity to launch
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    /**
     * First perform check if the app id matches with the flavor
     * this one check if its {black}
     */
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.gotoandplaynow.three.black", appContext.packageName)
    }

    @Test
    fun checkMainActivityButtonIds() {
        // get button one visibility
        Espresso.onView(ViewMatchers.withId(R.id.btn_1)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // assert if the label matches
        Espresso.onView(ViewMatchers.withId(R.id.btn_1)).check(ViewAssertions.matches(ViewMatchers.withText(R.string.btn_page_one_label)))

        // get button two visibility
        Espresso.onView(ViewMatchers.withId(R.id.btn_2)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // assert if the label matches
        Espresso.onView(ViewMatchers.withId(R.id.btn_2)).check(ViewAssertions.matches(ViewMatchers.withText(R.string.btn_page_two_label)))

        // get button three visibility
        Espresso.onView(ViewMatchers.withId(R.id.btn_3)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // assert if the label matches
        Espresso.onView(ViewMatchers.withId(R.id.btn_3)).check(ViewAssertions.matches(ViewMatchers.withText(R.string.btn_page_three_label)))

        // perform click
        Espresso.onView(ViewMatchers.withId(R.id.btn_1)).perform(ViewActions.click())

        checkDetailActivity()
    }

    private fun checkDetailActivity() {
        // check if the detail activity label is displayed
        Espresso.onView(ViewMatchers.withId(R.id.tv_label)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        // assert if the label matches
        Espresso.onView(ViewMatchers.withId(R.id.tv_label)).check(ViewAssertions.matches(ViewMatchers.withText(R.string.btn_page_one_label)))
    }
}
