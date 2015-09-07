package com.zwb.fsparser.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.zwb.fsparser.api.IGkFsEntry;
import com.zwb.fsparser.api.IGkFsParserError;
import com.zwb.fsparser.api.IGkFsParserResult;
import com.zwb.fsparser.api.IGkFsParserSearchLocation;

public class GkFsParserResult implements IGkFsParserResult
{
    List<IGkFsEntry> entries;
    List<IGkFsParserError> errors;
    List<IGkFsParserSearchLocation> locations = new ArrayList<>();
    
    @Override
    public List<IGkFsEntry> getEntries()
    {
	if (this.entries == null)
	{
	    this.entries = new ArrayList<>();
	    for (IGkFsParserSearchLocation l : this.getLocations())
	    {
		this.entries.addAll(l.getEntries());
	    }
	}
	return this.entries;
    }
    
    @Override
    public List<IGkFsParserError> getErrors()
    {
	if (this.errors == null)
	{
	    this.errors = new ArrayList<IGkFsParserError>();
	    for (IGkFsParserSearchLocation l : this.getLocations())
	    {
		this.errors.addAll(l.getErrors());
	    }
	}
	return this.errors;
    }
    
    public void addLocation(IGkFsParserSearchLocation location)
    {
	this.locations.add(location);
    }
    
    public void addLocations(IGkFsParserSearchLocation... locations)
    {
	for (IGkFsParserSearchLocation l : locations)
	{
	    this.addLocation(l);
	}
    }
    
    @Override
    public List<IGkFsParserSearchLocation> getLocations()
    {
	return this.locations;
    }
    
    @Override
    public String printFormatted()
    {
	throw new RuntimeException("NOT IMPLEMENTED YET!");
    }
}
