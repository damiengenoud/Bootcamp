package com.github.dgenoud.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.allOf;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void intentContainingNameIsFiredWhenButtonIsClicked() {
        Intents.init();

        // Open keyboard, type name and close keyboard
        onView(withId(R.id.mainName)).perform(click())
                .perform(clearText())
                .perform(typeTextIntoFocusedView("Steve"))
                .perform(closeSoftKeyboard());

        // Press the button
        onView(withId(R.id.mainGoButton)).perform(click());

        // Check the intent
        intended(allOf(hasComponent(GreetingActivity.class.getName())
                , hasExtra("name", "Steve")));

        Intents.release();
    }
}
