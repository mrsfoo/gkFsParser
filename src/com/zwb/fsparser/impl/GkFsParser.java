package com.zwb.fsparser.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import com.zwb.fsparser.api.IGkFsEntry;
import com.zwb.fsparser.api.IGkFsParser;
import com.zwb.fsparser.api.IGkFsParserSearchLocation;
import com.zwb.fsparser.api.IGkFsParserResult;

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
		for(IGkFsParserSearchLocation q: searchLocations)
		{
			GkFsParserSearchLocation loc = (GkFsParserSearchLocation)q;
			List<File> l = Util.getFsLeaves(q.getPath(), q.getDepth(), true);
			for(File f: l)
			{
				loc.addEntry(new GkFsEntry(f));
			}
			result.addLocation(loc);
		}
//		Collections.sort(result.getEntries());
		return result;
	}

}
