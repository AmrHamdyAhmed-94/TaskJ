package com.jpay.exception;

public class NoDataFound extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1966949637685869283L;

	public NoDataFound(String errorMessage) {
		super(errorMessage);
	}

}
