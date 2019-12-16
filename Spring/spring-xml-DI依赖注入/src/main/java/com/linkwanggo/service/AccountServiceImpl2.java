package com.linkwanggo.service;

import java.util.Date;

/**'
 * 通过set方式实现注入
 */
public class AccountServiceImpl2 implements IAccountService {

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

    @Override
    public String toString() {
        return "AccountServiceImpl2{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    public void saveAccount() {

    }
}
