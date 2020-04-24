package com.example.springboo2_jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "account_jpa")
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增主键
    private Integer id;
    @Column
    private Integer uid;
    @Column
    private double money;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}

