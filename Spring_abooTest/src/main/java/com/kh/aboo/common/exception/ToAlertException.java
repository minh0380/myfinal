package com.kh.aboo.common.exception;

import com.kh.aboo.common.code.ErrorCode;

public class ToAlertException extends CustomException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2364649591007100819L;

	public ToAlertException(ErrorCode error) {
		// TODO Auto-generated constructor stub
		super(error);
		
	}
	public ToAlertException(ErrorCode error, Exception e) {
		// TODO Auto-generated constructor stub
		super(error,e);
		
	}
}
