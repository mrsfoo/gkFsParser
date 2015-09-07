package com.zwb.fsparser.impl;

import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.zwb.fsparser.api.IGkFsParser;
import com.zwb.fsparser.api.IGkFsParserResult;
import com.zwb.fsparser.api.IGkFsParserSearchLocation;

public class GkFsParser implements IGkFsParser
{
    @Override
    public IGkFsParserResult parseFolders(IGkFsParserSearchLocation... searchLocations)
    {
	return parseFolders(Arrays.asList(searchLocations));
    }
    
    @Override
    public IGkFsParserResult parseFolders(Collection<IGkFsParserSearchLocation> searchLocations)
    {
	GkFsParserResult result = new GkFsParserResult();
	for (IGkFsParserSearchLocation q : searchLocations)
	{
	    GkFsParserSearchLocation loc = (GkFsParserSearchLocation) q;
	    Map<File, String> errorMap = new HashMap<File, String>();
	    List<File> l = Util.getFsLeaves(q.getPath(), q.getDepth(), true, errorMap);
	    for (File f : l)
	    {
		loc.addEntry(new GkFsEntry(f));
	    }
	    for (Entry<File, String> e : errorMap.entrySet())
	    {
		 loc.addErrorPath(e.getKey(), e.getValue());
	    }
	    result.addLocation(loc);
	}
	// Collections.sort(result.getEntries());
	return result;
    }
}
