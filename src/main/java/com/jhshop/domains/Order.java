package com.jhshop.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="ordertable")	//DB 정렬문과 겹침
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="orderid", nullable=false)
	private Long orderId;
	
	@ManyToOne
	@JoinColumn(name="user_order", referencedColumnName="userid")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="product_order", referencedColumnName="productname")
	private Product product;
	
}