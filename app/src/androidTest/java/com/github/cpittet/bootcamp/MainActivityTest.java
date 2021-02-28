package com.github.cpittet.bootcamp;

import android.content.Intent;
import android.widget.EditText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.Intents;
import androidx.test.espresso.intent.matcher.IntentMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;

@RunWith(AndroidJUnit4.class)

public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> testRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void intentIsFiredWhenUserClicksOnButton() {
        Intents.init();

        Espresso.onView(ViewMatchers.withId(R.id.mainName))
                .perform(clearText(), ViewActions.typeText("Cyrille"));
        closeSoftKeyboard();
        Espresso.onView(ViewMatchers.withId(R.id.mainGoButton))
                .perform(ViewActions.click());

        Intents.intended(Matchers.allOf(IntentMatchers.hasComponent(GreetingActivity.class.getName()), IntentMatchers.hasExtra(MainActivity.EXTRA_MESSAGE, "Cyrille")));

        Intents.release();
    }
}
