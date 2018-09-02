package com.jhshop.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
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

/**
 * @author JH
 * DB에 저장할 Product table의 data들을 생성하기 위한 클래스
 */
public class Product {
	
	@Id
	@Column(name="productid", nullable=false)
	private String productId;
	
	@Column(name="productname")
	private String productName;
	private String price;
}
