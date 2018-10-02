package com.sniper.music.home.robot;

import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.contrib.RecyclerViewActions;

import com.sniper.music.R;
import com.sniper.music.utils.RecyclerViewMatcher;
import com.sniper.music.utils.SpecTest;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class HomeScreenRobot {

    private SpecTest specTest = new SpecTest();

    public HomeScreenRobot isSearchIconVisible() {
        onView(withId(R.id.action_search)).check(matches(isDisplayed()));
        return this;
    }

    public HomeScreenRobot isSearchIconClickable() {
        onView(withId(R.id.action_search)).check(matches(isClickable()));
        return this;
    }

    public HomeScreenRobot clickSearchIcon() {
        onView(withId(R.id.action_search)).perform(click());
        return this;
    }

    public HomeScreenRobot enterSearchQuery(String query) {
        onView(withHint(InstrumentationRegistry.getTargetContext().getString(R.string.search_hint))).perform(typeText(query));
        return this;
    }

    public HomeScreenRobot isExpectedSearchResultDisplayed() {
        specTest.closeSoftKeyboard();
        onView(withId(R.id.search_results_recycler_view)).check(matches(isDisplayed()));
        final RecyclerViewMatcher recyclerViewMatcher = specTest.withRecyclerView(R.id.search_results_recycler_view);
        onView(recyclerViewMatcher.atPosition(0))
                .check(matches(hasDescendant(withText("Cher"))));
        onView(recyclerViewMatcher.atPosition(1))
                .check(matches(hasDescendant(withText("Cheryl Cole"))));
        onView(recyclerViewMatcher.atPosition(2))
                .check(matches(hasDescendant(withText("Cher Lloyd"))));
        onView(recyclerViewMatcher.atPosition(3))
                .check(matches(hasDescendant(withText("Black Stone Cherry"))));
        return this;
    }
}
