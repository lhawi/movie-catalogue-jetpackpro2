package com.lukmanhawi.moviecatalogue.home;

import android.content.Context;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.lukmanhawi.moviecatalogue.R;
import com.lukmanhawi.moviecatalogue.data.source.local.MovieEntity;
import com.lukmanhawi.moviecatalogue.data.source.local.TvEntity;
import com.lukmanhawi.moviecatalogue.ui.home.HomeActivity;
import com.lukmanhawi.moviecatalogue.utils.CatalogueIdlingResource;
import com.lukmanhawi.moviecatalogue.utils.DataDummy;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.swipeUp;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

public class HomeActivityTest {

    private List<MovieEntity> dummyMovies = DataDummy.generateDummyMovies();
    private List<TvEntity> dummyTv = DataDummy.generateDummyTv();

    @Rule
    public ActivityScenarioRule activityRule = new ActivityScenarioRule<>(HomeActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(CatalogueIdlingResource.getIdlingResource());
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(CatalogueIdlingResource.getIdlingResource());
    }

    @Test
    public void loadMovies() {
        onView(withText("Movie")).perform(click());
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.rv_movie))).perform(RecyclerViewActions.actionOnItemAtPosition(0, swipeUp()));
    }

    @Test
    public void loadTv() {
        onView(withText("TV Series")).perform(click());
        onView(allOf(isDisplayed(), withId(R.id.rv_tv))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.rv_tv))).perform(RecyclerViewActions.actionOnItemAtPosition(0, swipeUp()));
    }

    @Test
    public void loadDetailMovie() {
        onView(withText("Movie")).perform(click());
        onView(allOf(isDisplayed(), withId(R.id.rv_movie))).check(matches(isDisplayed()));
//        onView(allOf(isDisplayed(), withId(R.id.rv_movie))).perform(RecyclerViewActions.actionOnItemAtPosition(5, click()));
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(isDisplayed(), withId(R.id.text_title))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_title))).check(matches(withText(dummyMovies.get(0).getTitle())));
        onView(allOf(isDisplayed(), withId(R.id.text_date))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_date))).check(matches(withText(dummyMovies.get(0).getDate())));
        onView(allOf(isDisplayed(), withId(R.id.text_rate))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_rate))).check(matches(withText(dummyMovies.get(0).getRate())));
        onView(allOf(isDisplayed(), withId(R.id.text_description))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_description))).check(matches(withText(dummyMovies.get(0).getDescription())));
    }

    @Test
    public void loadDetailTv() {
        onView(withText("TV Series")).perform(click());
        onView(allOf(isDisplayed(), withId(R.id.rv_tv))).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(allOf(isDisplayed(), withId(R.id.text_ttitle))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_ttitle))).check(matches(withText(dummyTv.get(0).getTitle())));
        onView(allOf(isDisplayed(), withId(R.id.text_tdate))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_tdate))).check(matches(withText(dummyTv.get(0).getDate())));
        onView(allOf(isDisplayed(), withId(R.id.text_trate))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_trate))).check(matches(withText(dummyTv.get(0).getRate())));
        onView(allOf(isDisplayed(), withId(R.id.text_tdescription))).check(matches(isDisplayed()));
        onView(allOf(isDisplayed(), withId(R.id.text_tdescription))).check(matches(withText(dummyTv.get(0).getDescription())));
    }

}