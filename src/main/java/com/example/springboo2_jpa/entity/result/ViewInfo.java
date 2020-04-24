package com.example.springboo2_jpa.entity.result;

import com.example.springboo2_jpa.entity.Account;
import com.example.springboo2_jpa.entity.User;

import java.io.Serializable;

// 用于保存account和user表的级联查询的结果类
public class ViewInfo implements Serializable {

    private User user;
    private Account account;

    public ViewInfo() {
    }

    public ViewInfo(User user) {
        Account account = new Account();
        this.account = account;
        this.user = user;
    }

    public ViewInfo(Account account) {
        User user = new User();
        this.account = account;
        this.user = user;
    }

    public ViewInfo(User user, Account account) {
        this.user = user;
        this.account = account;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
