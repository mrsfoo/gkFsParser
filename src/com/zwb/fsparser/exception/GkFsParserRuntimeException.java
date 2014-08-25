package com.zwb.fsparser.exception;

public class GkFsParserRuntimeException extends RuntimeException
{
	public GkFsParserRuntimeException(String message)
	{
		super(message);
	}
	
	public GkFsParserRuntimeException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
