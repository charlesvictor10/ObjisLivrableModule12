package com.objis.spring.demoinjection;

public class PerformanceException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public PerformanceException() {
		super();
	}

	public PerformanceException(String message) {
		super(message);
	}
}
