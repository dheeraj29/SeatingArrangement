package com.exam.generate.exception;

public class InsufficientSeats extends Exception {

	private static final long serialVersionUID = 1L;

	public InsufficientSeats(String message) {
		super(message);
	}
}
