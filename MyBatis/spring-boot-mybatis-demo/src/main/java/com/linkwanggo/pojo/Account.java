package com.linkwanggo.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class Account {

    private Long id;

    private String username;

    private Double money;

    private Date createTime;
}
