package com.linkwanggo.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
public class User {

    private String username;

    private User friend;

    private List<User> list;

    private Map<String, User> map;

}
