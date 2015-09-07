package com.zwb.fsparser.api;

public interface IGkFsParserError extends Comparable<IGkFsParserError>
{
    public String getErrorPath();
    public String getErrorReason();
    public String getErrorFilename();
}
