package com.lambdaschool.orders.repos;

import com.lambdaschool.orders.model.Orders;
import org.springframework.data.repository.CrudRepository;

public interface OrdersRespository extends CrudRepository<Orders, Long> {

}
