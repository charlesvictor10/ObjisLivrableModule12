package com.objis.demospringsecurity.domaine;


public class Personne {
	
private Long id;
private String login;
private String password;
private String prenom;
private String nom;
private String email;
private String country;
private boolean enabled;  // Authentification permise pour cet utilisateur ?


public Long getId() {
	return id;
}

public String getNom() {
	return nom;
}

public String getPrenom() {
	return prenom;
}

public boolean getEnabled() {
	return enabled;
}

public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}

public void setId(Long id) {
	this.id = id;
}

public void setNom(String nom) {
	this.nom = nom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public void setLogin(String login) {
	this.login = login;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


public String getLogin() {
	return this.login;
}


public Personne() {
	super();
}

public Personne(Long id, String login, String password, String prenom, String nom,
		String email, String country, boolean enabled) {
	super();
	this.id = id;
	this.login = login;
	this.password = password;
	this.prenom = prenom;
	this.nom = nom;
	this.email = email;
	this.country = country;
	this.enabled = enabled;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}
}

