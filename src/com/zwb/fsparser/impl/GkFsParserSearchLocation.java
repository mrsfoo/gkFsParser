package com.zwb.fsparser.impl;

import java.util.ArrayList;
import java.util.List;

import com.zwb.fsparser.api.IGkFsEntry;
import com.zwb.fsparser.api.IGkFsParserSearchLocation;

public class GkFsParserSearchLocation implements IGkFsParserSearchLocation
{
    private String path;
    private int depth;
    private List<IGkFsEntry> entries = new ArrayList<>();
    private String name;
    
    public GkFsParserSearchLocation(String name, String path, int depth)
    {
	this.path = path;
	this.depth = depth;
	this.name = name;
    }
    
    @Override
    public String getPath()
    {
	return this.path;
    }
    
    @Override
    public int getDepth()
    {
	return this.depth;
    }
    
    public void addEntry(IGkFsEntry entry)
    {
	this.entries.add(entry);
    }
    
    public void addEntries(IGkFsEntry... entries)
    {
	for (IGkFsEntry e : entries)
	{
	    this.addEntry(e);
	}
    }
    
    @Override
    public List<IGkFsEntry> getEntries()
    {
	return this.entries;
    }
    
    @Override
    public String getLocationName()
    {
	return this.name;
    }
    
}
