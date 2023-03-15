package com.loska.hellokode.model;

import lombok.Data;

@Data
public class MovieSearchResponse {

    private Integer page;
    private Movie[] results;
    private Integer total_results;
    private Integer total_pages;

}
