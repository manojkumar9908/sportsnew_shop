package com.sportsshop.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sportsshop.dao.ProductRepository;
import com.sportsshop.model.Products;

@RestController
public class ProductsDetailsController {
	@Autowired
	ProductRepository productRepository;

	@PostMapping("product/save")
	public void save(@RequestBody Products product) {
		productRepository.save(product);
	}

	@GetMapping("product/list")
	public List<Products> findAll() {
		List<Products> productList = productRepository.findAll();
		return productList;
	}

	@DeleteMapping("product/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productRepository.deleteById(id);
	}

	@PutMapping("product/{id}")
	public void update(@PathVariable("id") Integer id, @RequestBody Products product) {
		product.setId(id);
		Products productObj = productRepository.findById(id).get();
		productObj.setName(product.getName());//update
		productRepository.save(productObj);
	}

	@GetMapping("product/{id}")
	public Products findById(@PathVariable("id") Integer id) {
		Optional<Products> product = productRepository.findById(id);
		if (product.isPresent()) {
			Products productObj = product.get();
			return productObj;
		} else {
			return null;
		}
	}
}
