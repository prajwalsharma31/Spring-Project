package com.springproject.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.annotation.Generated;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String fname;
	private String lname;
	private String Gender;
	private String phone;
	private String email;
	
	@DateTimeFormat(iso =ISO.DATE)
	private LocalDate dob;
	private  String company;
	private String post;
	
	@DateTimeFormat(iso =ISO.DATE)
	private LocalDate JoinDate;
	private int salary;
	
	@ManyToMany //(cascade =CascadeType.ALL ,fetch = FetchType.EAGER)
	private List<Department> department;
	
	@OneToOne(cascade =CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	@ElementCollection
	@CollectionTable
	private List <String> projects;
	

}
