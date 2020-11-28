package com.objis.spring.demoinjection;

import java.util.Collection;

public class GroupeMusique implements Performeur {

	public GroupeMusique() {
		super();
	}
	
	public void performe() throws PerformanceException {
		for(Instrument instrument : instruments) {
		instrument.jouer();
		}
	}
	
	private Collection<Instrument> instruments;
	public void setInstruments(Collection<Instrument> instruments) {
		this.instruments = instruments;
	}
}
