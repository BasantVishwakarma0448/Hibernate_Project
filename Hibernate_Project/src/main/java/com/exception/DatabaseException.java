package com.exception;

public class DatabaseException extends Exception{
	/**
	 * @author Basant Vishwakarma
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseException(String msg){
		super(msg);
	}
}
