package com.zwb.fsparser.impl;

import java.io.File;

import com.zwb.fsparser.api.IGkFsEntry;
import com.zwb.fsparser.api.IGkFsParserError;

public class GkFsParserError implements IGkFsParserError
{
    String errorReason;
    File errorFile;
    
    public GkFsParserError(File errorFile, String errorReason)
    {
	this.errorFile = errorFile;
	this.errorReason = errorReason;
    }
    
    public GkFsParserError(String errorPath)
    {
	this.errorFile = errorFile;
	this.errorReason = "UNKNOWN";
    }
    
    @Override
    public String getErrorPath()
    {
	return this.errorFile.getAbsolutePath();
    }
    
    @Override
    public String getErrorFilename()
    {
	return this.errorFile.getName();
    }
    
    @Override
    public String getErrorReason()
    {
	return this.errorReason;
    }
    
    @Override
    public int compareTo(IGkFsParserError o)
    {
	return this.getErrorPath().compareTo(o.getErrorPath());
    }
    
}
