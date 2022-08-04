package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "member_types")
@Data
public class MemberType {
	
	@Id
	private Integer id;
	private String name;
	
	// mappedBy: MemberクラスのmemberTypeフィールドにJOINの情報が記されている
	@OneToMany(mappedBy = "memberType")
	private List<Member> members;

}
