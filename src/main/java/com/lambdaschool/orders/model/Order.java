package com.lambdaschool.orders.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity

@Table(name = "order")
public class Order {
    private long orderid;
}
