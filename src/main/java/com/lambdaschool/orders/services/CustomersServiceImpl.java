package com.lambdaschool.orders.services;

import com.lambdaschool.orders.model.Agents;
import com.lambdaschool.orders.model.Customers;
import com.lambdaschool.orders.model.Orders;
import com.lambdaschool.orders.repos.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customersService")
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    private CustomersRepository custrepos;

    @Override
    public List<Customers> findAll() {
        List<Customers> list = new ArrayList<>();
        custrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findCustomerById(long id) throws EntityNotFoundException {
        return custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Override
    public Customers findCustomersByCustname(String custname) {
        Customers customer = custrepos.findByCustname((custname));

        if (customer == null) {
            throw new EntityNotFoundException("Customer " + custname + " not found!");
        }
        return customer;
    }

    @Override
    public void delete(long id) {
    if(custrepos.findById(id).isPresent()) {
        custrepos.deleteById(id);
    }else {
        throw  new EntityNotFoundException((Long.toString(id)));
    }
    }

    @Transactional
    @Override
    public Customers save(Customers customers) {
        Customers newCustomer = new Customers();

        newCustomer.setCustname(customers.getCustname());
        newCustomer.setWorkingarea(customers.getWorkingarea());
        newCustomer.setCustcountry(customers.getCustcountry());
        newCustomer.setGrade(customers.getGrade());
        newCustomer.setOpeningamt(customers.getOpeningamt());
        newCustomer.setReceiveamt(customers.getReceiveamt());
        newCustomer.setPaymentamt(customers.getPaymentamt());
        newCustomer.setOutstandingamt(customers.getOutstandingamt());
        newCustomer.setPhone(customers.getPhone());

        for (Orders o : customers.getOrders()) {
            newCustomer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), o.getCustomer(), o.getAgent(), o.getOrdersescription(), newCustomer));
        }

        for (Agents a : customers.getAgent()) {
            newCustomer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), o.getCustomers(), o.getAgents(), o.getOrddescription(), newCustomer));
        }
        return custrepos.save(newCustomer);
    }

    @Transactional
    @Override
    public Customers update(Customers customers, long id) throws EntityNotFoundException {

        Customers currentCustomer = custrepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (customers.getCustname() != null) {
            currentCustomer.setCustname(customers.getCustname());
        }
        if (customers.getWorkingarea() != null) {
            currentCustomer.setWorkingarea(customers.getWorkingarea());
        }
        if (customers.getCustcountry() != null) {
            currentCustomer.setCustcountry(customers.getCustcountry());
        }
        if (customers.getGrade() != null) {
            currentCustomer.setGrade(customers.getGrade());
        }
        if (customers.getOpeningamt() > 0) {
            currentCustomer.setOpeningamt(customers.getOpeningamt());
        }
        if (customers.getReceiveamt() > 0) {
            currentCustomer.setReceiveamt(customers.getReceiveamt());
        }
        if (customers.getPaymentamt() > 0) {
            currentCustomer.setPaymentamt(customers.getPaymentamt());
        }
        if (customers.getOutstandingamt() > 0) {
            currentCustomer.setOutstandingamt(customers.getOutstandingamt());
        }
        if (customers.getPhone() != null) {
            currentCustomer.setPhone(customers.getPhone());
        }
        for (Orders o : customers.getOrders()) {
            currentCustomer.getOrders().add(new Orders(o.getOrdamount(), o.getAdvanceamount(), o.getCustomer(), o.getAgent(), o.getOrdersescription(), currentCustomer));
        }
        return custrepos.save(currentCustomer);
    }
}
