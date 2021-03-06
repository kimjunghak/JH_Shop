package com.jhshop.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

/**
 * @author JH
 * DB에 저장할 User table의 data들을 생성하기 위한 클래스
 */

public class User {
	
	@Id
	@GeneratedValue
	@Column(name="usernumber")
	private long userNumber;
	
	@Column(name="userid", nullable=false, length=20)
	private String userId;
	@Column(nullable=false, length=20)
	private String pw;
	private String name;
	private String email;
}
