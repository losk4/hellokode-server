package com.loska.hellokode.model;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Movie {

    private String poster_path;
    private Boolean adult;
    private String overview;
    private String release_date;
    private ArrayList<Integer> genre_ids;
    private Integer id;
    private String original_title;
    private String original_language;
    private String title;
    private String backdrop_path;
    private Number popularity;
    private Number vote_count;
    private Boolean video;
    private Number vote_average;

}
