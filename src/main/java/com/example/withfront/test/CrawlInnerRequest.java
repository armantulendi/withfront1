package com.example.withfront.test;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrawlInnerRequest {

    private String url;
    private String callback;
    @JsonProperty("dont_filter")
    private String dontFilter;
}



