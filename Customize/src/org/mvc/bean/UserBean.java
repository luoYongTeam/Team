package org.mvc.bean;

import java.util.Arrays;

/**
 * Created by Administrator on 2016/12/13.
 */
public class UserBean {
    private String userName;
    private int userAge;
    private int id;
    private String[] addr;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getAddr() {
        return addr;
    }

    public void setAddr(String[] addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", userAge=" + userAge +
                ", id=" + id +
                ", addr=" + Arrays.toString(addr) +
                '}';
    }
}
