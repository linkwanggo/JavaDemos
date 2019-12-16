package com.linkwanggo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Account {

    private Integer id;

    private String username;

    private Float money;

    private Date create_time;
}
