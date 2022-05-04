package com.sportsshop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportsshop.model.Products;

@Repository
public interface ProductRepository  extends JpaRepository<Products,Integer> {

}
