package com.films.model;

public enum Rating {
    ONE_STAR("*"),
    TWO_STAR("**"),
    THREE_STAR("***"),
    FOUR_STAR("****"),
    FIVE_STAR("*****");

    String rating;

    Rating(String rating) {
        this.rating = rating;
    }
}
