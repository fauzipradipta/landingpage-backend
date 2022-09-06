package com.landingpage.landingpagebackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.landingpage.landingpagebackend.Entity.Items;


//@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {

	Optional<Items> findByName(String itemName);
    
}
