package com.zwb.fsparser.api;

import java.util.List;

public interface IGkFsParserSearchLocation
{
    public String getPath();    
    public int getDepth();
    public List<IGkFsEntry> getEntries();    
    public String getLocationName();    
    public List<IGkFsParserError> getErrors();
    
}
