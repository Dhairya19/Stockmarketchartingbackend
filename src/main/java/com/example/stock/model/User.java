package com.example.stock.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@Column(name = "username",unique = true)
	@NotNull
	private String name;

	@Column(name = "password")
	@NotNull
	private String password;

	@Column(name="email",unique = true)
	@NotNull
	private String email;

	@Column(name = "mobile",unique = true)
	@NotNull
	private int mobile;

	@Column(name = "confirmed")
	private int Confirmed;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public User() {
	}

	public User(int id, String name, String password, String email, int mobile, int confirmed, int admin) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		Confirmed = confirmed;
		Admin = admin;
	}

	public String getEmail() {
		return email;
	}

	public int getMobile() {
		return mobile;
	}

	public int getConfirmed() {
		return Confirmed;
	}

	public int getAdmin() {
		return Admin;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public void setConfirmed(int confirmed) {
		Confirmed = confirmed;
	}

	public void setAdmin(int admin) {
		Admin = admin;
	}

	@Column(name = "admin")
	private int Admin;
}


	