package com.jhshop.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="ordertable")	//DB 정렬문과 겹침

/**
 * @author JH
 * DB에 저장할 Order table의 data들을 생성하기 위한 클래스
 */
public class Order {
	
	@Id
	@GeneratedValue
	@Column(name="orderid", nullable=false)
	private Long orderId;
	
	@JoinColumn(name="user_order", referencedColumnName="userid")
	private String userId;
	
	@JoinColumn(name="product_order", referencedColumnName="productname")
	private String productName;
	
}
