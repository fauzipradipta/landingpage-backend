package com.landingpagebackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.landingpagebackend.Entity.User;

public interface UserRepository extends JpaRepository<Long, User> {

}
