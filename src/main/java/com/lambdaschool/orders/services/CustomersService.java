package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Customers;

import java.util.List;

public interface CustomersService {
    List<Customers> findAll();

    Customers findCustomerById(long id);

    Customers findCustomersByCustname(String custname);

    void delete(long id);

    Customers save(Customers customers);

    Customers update(Customers customers, long id);
}
