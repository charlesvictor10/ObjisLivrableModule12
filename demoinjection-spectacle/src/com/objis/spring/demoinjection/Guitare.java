package com.objis.spring.demoinjection;

public class Guitare implements Instrument {
	
	public void init() {
		System.out.println("initialisation de l'objet guitare");
	}
	
	public void destroy() {
		System.out.println("destruction de l'objet guitare");
	}

	@Override
	public void jouer() {
		System.out.println("Guitar guitar");	
	}
}
