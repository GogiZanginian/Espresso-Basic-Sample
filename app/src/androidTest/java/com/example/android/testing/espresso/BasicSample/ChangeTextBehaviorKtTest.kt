package com.example.android.testing.espresso.BasicSample

import androidx.test.ext.junit.rules.activityScenarioRule
import android.app.Activity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class ChangeTextBehaviorKtTest {

    companion object {
        private const val FAVORITE_FOOD = "Pizza"
        private const val FAVORITE_MOVIE = "Scarface"
        private const val FAVORITE_MOVIE2 = "Creed"
    }

    @get:Rule
    var activityScenarioRule = activityScenarioRule<MainActivity>()

    @Test
    fun changeText_displaysFavoriteFood() {

        onView(withId(R.id.editTextUserInput))
            .perform(typeText(FAVORITE_FOOD), closeSoftKeyboard())

        onView(withId(R.id.changeTextBt))
            .perform(click())


        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(FAVORITE_FOOD)))
    }

    @Test
    fun changeText_displaysFavoriteMovie() {
        onView(withId(R.id.editTextUserInput))
            .perform(
                typeText(FAVORITE_MOVIE),
                closeSoftKeyboard()
            )

        onView(withId(R.id.changeTextBt))
            .perform(click())

        onView(withId(R.id.textToBeChanged))
            .check(matches(withText(FAVORITE_MOVIE)))


        onView(withId(R.id.editTextUserInput))
            .perform(clearText(), typeText(FAVORITE_MOVIE2), closeSoftKeyboard())

        onView(withId(R.id.activityChangeTextBtn))
            .perform(click())

        onView(withId(R.id.show_text_view))
            .check(matches(withText(FAVORITE_MOVIE2)))
    }
}