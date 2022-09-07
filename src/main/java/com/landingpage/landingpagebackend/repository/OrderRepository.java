package com.landingpage.landingpagebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.landingpage.landingpagebackend.Entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
