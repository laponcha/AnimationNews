package com.example.android.animationnews;


import android.content.Context;
import android.nfc.Tag;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * {@link AnimationNewsAdapter}is an {@link ArrayAdapter}that can provide the layout for each list item
 * based on a  data source, which is a list of {@link AnimationNews} objects.
 */

class AnimationNewsAdapter extends ArrayAdapter<AnimationNews> {

    /**
     * @param context       is the current context (i.e. Activity)that the adapter is being created in.
     * @param animationNews is the list of {@link AnimationNews}to be displayed.
     */

    public AnimationNewsAdapter(Context context, List<AnimationNews> animationNews) {
        super(context, 0, animationNews);

    }

    /**
     * Return a list item view that displays information about the news at the given position
     * in the list of news.
     */

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.animation_news_list_item, parent, false);
        }

        // Get the News object located at this position in the list.
        AnimationNews currentAnimationNews = getItem(position);




        // Find the TextView in the news_list_item.xml layout with the ID title.
        TextView titleView = listItemView.findViewById(R.id.title);
        titleView.setText(currentAnimationNews.getTitle());

        // Find the TextView in the news_list_item.xml layout with the ID topics.
        TextView sectionView = listItemView.findViewById(R.id.section);
        sectionView.setText(currentAnimationNews.getSection());



        // Find the TextView in the news_list_item.xml layout with the ID topics.
        TextView authorView = listItemView.findViewById(R.id.author);
        // Display the author of the current news in that TextView
        if (currentAnimationNews.getAuthor() != ""){
            authorView.setText(currentAnimationNews.getAuthor());
            // Set author view as visible
            authorView.setVisibility(View.VISIBLE);
        }else {
            //Set author view as gone
            authorView.setVisibility(View.GONE);
        }

        // Find the TextView with view ID date
        TextView dateView = null;
        TextView timeView = null;
        if (currentAnimationNews.getDate() != null) {
            dateView = listItemView.findViewById(R.id.date);
            // Format the date string (i.e. "April 6, 2015")
            String formattedDate = formatDate(currentAnimationNews.getDate()).concat(",");
            // Display the date of the current news in that TextView
            dateView.setText(formattedDate);

            // Find the TextView with view ID time
            timeView = listItemView.findViewById(R.id.time);
            // Format the time string (i.e. "10:15PM")
            String formattedTime = formatTime(currentAnimationNews.getDate());
            // Display the time of the current news in that TextxView
            timeView.setText(formattedTime);

            // Set date and time views as visible
            dateView.setVisibility(View.VISIBLE);
            timeView.setVisibility(View.VISIBLE);
        }else {
            //Set and time as gone
            dateView.setVisibility(View.GONE);
            timeView.setVisibility(View.GONE);
        }


        //return the list item view that is now showing the appropriate data
        return listItemView;
    }


    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}


