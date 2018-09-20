package com.example.android.animationnews;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Loads a list news using an AsynTask to perform the
 * network request to the given URL
 */


class AnimationNewsLoader extends AsyncTaskLoader<List<AnimationNews>> {

    /**
     * Query URL
     */
    private final String queryUrl;

    /**
     * Constructs a new {@link AnimationNewsLoader}.
     *
     * @param context of the activity
     * @param url to load data from
     */
    public AnimationNewsLoader(Context context, String url) {
        super(context);
        queryUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<AnimationNews> loadInBackground() {
        if (queryUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of news (and return this data at the end)
        return QueryUtils.fetchNewsData(queryUrl);

    }
}
