package com.linkwanggo.service;

import java.util.Date;

public class AccountServiceImpl implements IAccountService {

    private String username;
    private Integer age;
    private Date birthday;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public AccountServiceImpl() {}

    public AccountServiceImpl(String username, Integer age, Date birthday) {
        this.username = username;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void saveAccount() {
        System.out.println("存入账户");
    }

}
