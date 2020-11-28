package com.objis.spring.demo;

public class SocieteDevLogiciel {
	private Developpeur developpeur;
	private Developpeur chefDeveloppeur;
	
	public Developpeur getDeveloppeur() {
		return developpeur;
	}
	
	public void setDeveloppeur(Developpeur developpeur) {
		this.developpeur = developpeur;
	}
	
	public Developpeur getChefDeveloppeur() {
		return chefDeveloppeur;
	}
	
	public void setChefDeveloppeur(Developpeur chefDeveloppeur) {
		this.chefDeveloppeur = chefDeveloppeur;
	}
}
