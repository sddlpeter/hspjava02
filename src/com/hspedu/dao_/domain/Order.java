package com.hspedu.dao_.domain;

import java.util.Date;

public class Order {
    private Integer id;
    private Integer customer_id;
    private String customer_name;
    private Date date;
    private Double total;

    public Order() {

    }

    public Order(Integer id, Integer customer_id, String customer_name, Date date, Double total) {
        this.id = id;
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.date = date;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", customer_id=" + customer_id +
                ", customer_name='" + customer_name + '\'' +
                ", date=" + date +
                ", total=" + total +
                '}';
    }
}
