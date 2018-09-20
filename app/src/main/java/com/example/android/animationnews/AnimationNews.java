package com.example.android.animationnews;

import java.util.Date;

/**
 * An {@link AnimationNews} object contains information related to a single earthquake.
 */
public class AnimationNews {

    /**
     * Title of the news
     */
    private final String newsTitle;

    /**
     * Section of the news
     */
    private final String newsSection;


    /**
     * Website URL of the news
     */
    private final String newsUrl;

    /**
     * Author of the news
     */
    private final String newsAuthor;

    /**
     * Date of the news
     */
    private final Date newsDate;


    /**
     * Constructs a new {@link AnimationNews} object.
     *
     * @param title   is the title of the news
     * @param section is the subject where the news is classified
     * @param url     is the Website where the news information is located
     * @param author is the author of the article
     * @param date is the date that the article was published.
     */

    public AnimationNews(String title, String section, String url, String author, Date date) {
        newsTitle = title;
        newsSection = section;
        newsUrl = url;
        newsAuthor = author;
        newsDate = date;


    }

    /**
     * Returns the title of the news.
     */
    public String getTitle() {
        return newsTitle;
    }

    /**
     * Returns the section of the news.
     */
    public String getSection() {
        return newsSection;
    }


    /**
     * Return the Website where the news information is located
     */
    public String getUrl() {
        return newsUrl;
    }

    /**
     * Returns the Author of the news.
     */
    public String getAuthor() {
        return newsAuthor;
    }
    /**
     * Returns Date of the news.
     */
    public Date getDate(){
        return newsDate;
    }


}
