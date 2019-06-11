package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository custrepos;
    
    @Override
    public List<Customers> findAll() {
        return null;
    }

    @Override
    public Customers findCustomerById(long id) {
        return null;
    }

    @Override
    public Customers findCustomersByCustname(String custname) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Customers save(Customers customers) {
        return null;
    }

    @Override
    public Customers update(Customers customers, long id) {
        return null;
    }
}
