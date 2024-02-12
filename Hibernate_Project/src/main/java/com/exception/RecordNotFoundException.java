package com.exception;

public class RecordNotFoundException extends Exception{
	/**
	 * @author Basant Vishwakarma
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String msg){
		super(msg);
	}
}
