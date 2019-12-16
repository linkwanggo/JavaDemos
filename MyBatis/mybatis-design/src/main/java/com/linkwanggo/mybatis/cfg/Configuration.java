package com.linkwanggo.mybatis.cfg;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Configuration {

    private String driver;
    private String url;
    private String username;
    private String password;

    private Map<String, Mapper> mappers = new HashMap<>();

    public void setMappers(Map<String, Mapper> mappers) {
        this.mappers.putAll(mappers);
    }
}
