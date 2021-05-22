package com.jayc.opensource.model;

public class Ratings {
    private String name;
    private float rating;
    private String suggestion;


    public Ratings(String name, float rating, String suggestion) {
        this.name = name;
        this.rating = rating;
        this.suggestion = suggestion;

    }
    public Ratings() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
}

