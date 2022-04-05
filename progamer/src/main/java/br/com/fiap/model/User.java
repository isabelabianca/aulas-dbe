package br.com.fiap.model;

import java.time.LocalDate;

public class User {
	private String name = "Nome Completo";
	private LocalDate birthDate = LocalDate.of(1996, 10, 27);
	private String email = "email@email.com";
	private String password = "Pa$$w0rd";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", birthDate=" + birthDate + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
}
