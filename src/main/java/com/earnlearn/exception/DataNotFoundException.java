package com.earnlearn.exception;

/**
 * User defined exception for handling invalid data
 * 
 * @author rutuja jadhav
 *  * @date 11/11/2021
 *
 */
public class DataNotFoundException extends RuntimeException{

	public DataNotFoundException() {
		
	}
	
	public DataNotFoundException(String msg) {
		super(msg);
	}
}
