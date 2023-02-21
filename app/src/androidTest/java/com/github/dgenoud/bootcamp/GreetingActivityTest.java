package com.github.dgenoud.bootcamp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class GreetingActivityTest {
    @Test
    public void greetingMessageIsDisplayedAndContainsTypedName() {
        Intent launchIntent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        launchIntent.putExtra("name", "Steve");

        try (ActivityScenario<MainActivity> ignored = ActivityScenario.launch(launchIntent)) {
            onView(withId(R.id.greetingMessage)).check(matches(withText("Hi Steve !")));
        }
    }
}
