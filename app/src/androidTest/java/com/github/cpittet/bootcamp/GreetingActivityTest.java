package com.github.cpittet.bootcamp;

import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)


public class GreetingActivityTest {

    @Test
    public void greetingActivityDisplaysNameCorrectly() {
        // Use this context instead of the "this" in the MainActivity
        Intent intent = new Intent(ApplicationProvider.getApplicationContext(), GreetingActivity.class);
        intent.putExtra(MainActivity.EXTRA_MESSAGE, "Cyrille");

        try(ActivityScenario<GreetingActivity> scenario = ActivityScenario.launch(intent)) {
            Espresso.onView(ViewMatchers.withId(R.id.greetingText)).check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("Cyrille"))));
        }
    }

}
