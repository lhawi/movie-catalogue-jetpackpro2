package com.lukmanhawi.moviecatalogue.utils;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.idling.CountingIdlingResource;

public class CatalogueIdlingResource {
    private static CountingIdlingResource mCountingIdlingResource =
            new CountingIdlingResource("catalogue_idling_resource");

    public static IdlingResource getIdlingResource() {
        return mCountingIdlingResource;
    }

    public static void increment() {
        mCountingIdlingResource.increment();
    }

    public static void decrement() {
        mCountingIdlingResource.decrement();
    }
}
