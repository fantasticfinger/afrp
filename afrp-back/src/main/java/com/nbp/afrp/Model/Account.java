package com.nbp.afrp.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class Account{
	
    @Id @GeneratedValue
//	@Column(name = "num")
//    private Long num;
	@Column(name = "id")
	private String id = "";
	@Column(name = "pw")
	private String pw = "";
	@Column(name = "name")
	private String name = "";
	@Column(name = "phone")
	private String phone = "";	
	@Column(name = "email")
	private String email = "";
	@Column(name = "type_au")
	private String type_au;
	
	@Column(name = "team_name")
	private String team_name;
	
	
	
//	public Long getNum() {
//		return num;
//	}
//
//	public void setNum(Long num) {
//		this.num = num;
//	}

	public String getType_au() {
		return type_au;
	}

	public void setType_au(String type_au) {
		this.type_au = type_au;
	}

	public String getTeam_name() {
		return team_name;
	}

	public void setTeam_name(String team_name) {
		this.team_name = team_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type_au;
	}

	public void setType(String type) {
		this.type_au = type;
	}

	public String getPw() {
		// TODO Auto-generated method stub
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}

}
