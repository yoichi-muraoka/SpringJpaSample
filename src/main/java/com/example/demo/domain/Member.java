package com.example.demo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "members")
@Data
public class Member {
	
	@Id
	private Integer id;
	private String name;
	private Integer age;
	private String address;
	private Date created;
	
	// type_id を複数個所にマッピングできないためコメントアウト
	// private Integer typeId;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private MemberType memberType;

}
