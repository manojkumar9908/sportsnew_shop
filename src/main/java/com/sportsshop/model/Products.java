package com.sportsshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="sports_products")

public class Products {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //AUTOINCREMENT
	@Column (name="id")
	private Integer id;
	private String name;
	
    private String brand;
    
	private String category;
	
	private String price;
	
}
