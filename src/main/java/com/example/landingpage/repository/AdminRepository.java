package com.example.landingpage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.landingpage.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
	
}
