package com.zwb.fsparser.api;

import java.util.List;

public interface IGkFsParserResult
{
    public List<IGkFsEntry> getEntries();
    public List<IGkFsParserSearchLocation> getLocations();
    public String printFormatted();
    public List<IGkFsParserError> getErrors();
    
}
