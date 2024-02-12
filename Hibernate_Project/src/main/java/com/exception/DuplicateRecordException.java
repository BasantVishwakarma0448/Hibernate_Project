package com.exception;

public class DuplicateRecordException extends Exception{
	/**
	 * @author Basant Vishwakarma
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateRecordException(String msg){
		super(msg);
	}
}
