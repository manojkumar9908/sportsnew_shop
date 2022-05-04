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
@Entity(name="Sports_users")


public class User {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncrement
	@Column(name = "id")
	private int id;
	@Column(name = "Name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "mobile")
	private String mobile;
	

}
