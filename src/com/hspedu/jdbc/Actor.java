package com.hspedu.jdbc;

import java.time.LocalDateTime;
import java.util.Date;

public class Actor { //JavaBean, POJO, Domain 对象
    private Integer id;
    private String name;
    private String sex;
    private Date birthDate;
    private String phone;

    public Actor() { // 一定要给一个无参构造器，反射需要

    }


    public Actor(Integer id, String name, String sex, Date birthDate, String phone) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthDate=" + birthDate +
                ", phone='" + phone + '\'' +
                '}';
    }
}