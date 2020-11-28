package com.objis.spring.demoinjection;

public class Violon implements Instrument {

	@Override
	public void jouer() {
		System.out.println("Violon violon");
	}
}
