package com.segu.lab_3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.DrawerMatchers.isClosed;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import android.content.pm.ActivityInfo;
import android.view.Gravity;

import androidx.test.espresso.contrib.DrawerActions;
import androidx.test.espresso.contrib.NavigationViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class NavigationTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityRule = new ActivityScenarioRule<>(MainActivity.class);

    private void openAbout() {
        onView(withId(R.id.drawer_layout))
                .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
                .perform(DrawerActions.open()); // Open Drawer

        // Start the screen of your activity.
        onView(withId(R.id.nav_view))
                .perform(NavigationViewActions.navigateTo(R.id.about));
    }

    @Test
    public void fragment1ToAbout_back() {
        openAbout();
        onView(withId(R.id.about_activity)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment1To2() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2To1_back() {
        onView(withId(R.id.to_second_btn)).perform(click());
        pressBack();
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2To1_btn() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_first_btn)).perform(click());
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2ToAbout_back() {
        onView(withId(R.id.to_second_btn)).perform(click());
        openAbout();
        onView(withId(R.id.about_activity)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment2To3() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3ToAbout_back() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());
        openAbout();
        onView(withId(R.id.about_activity)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To2_back() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());

        pressBack();

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }


    @Test
    public void fragment3To2_btn() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());

        onView(withId(R.id.to_second_btn)).perform(click());

        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To1_back() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());

        pressBack();
        pressBack();

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To1_btn() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());

        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_first_btn)).perform(click());

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void fragment3To1_btn_immediately() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());

        onView(withId(R.id.to_first_btn)).perform(click());

        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void changeOrientationMainActivity() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));

        mActivityRule.getScenario().onActivity(activity ->
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));

        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

    @Test
    public void changeOrientationAboutActivity() {
        onView(withId(R.id.to_second_btn)).perform(click());
        onView(withId(R.id.to_third_btn)).perform(click());
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
        openAbout();
        onView(withId(R.id.about_activity)).check(matches(isDisplayed()));

        mActivityRule.getScenario().onActivity(activity ->
                activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE));

        pressBack();
        onView(withId(R.id.fragment3)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment2)).check(matches(isDisplayed()));
        pressBack();
        onView(withId(R.id.fragment1)).check(matches(isDisplayed()));
    }

}



