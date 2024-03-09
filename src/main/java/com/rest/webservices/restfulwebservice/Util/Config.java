package com.rest.webservices.restfulwebservice.Util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "cur-ser")
@Component
public class Config {

    String url;
    Integer ttm;

    public Config() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getTtm() {
        return ttm;
    }

    public void setTtm(Integer ttm) {
        this.ttm = ttm;
    }
}
