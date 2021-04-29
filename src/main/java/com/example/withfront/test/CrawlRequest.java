package com.example.withfront.test;

import com.example.withfront.test.CrawlInnerRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CrawlRequest {
    @JsonProperty("jsonrpc")
    private String jsonrpc;
    @JsonProperty("method")
    private String method;

    public CrawlRequest(String jsonrpc, String method) {
        this.jsonrpc = jsonrpc;
        this.method = method;
    }
}

