package com.jhshop.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Service
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	
	@Id
	@Column(name="productid", nullable=false)
	private String productId;
	
	@Column(name="productname")
	private String productName;
	private String price;
}
