package com.zwb.fsparser.api;

import com.zwb.fsparser.impl.GkFsParser;
import com.zwb.fsparser.impl.GkFsParserSearchLocation;

public class GkFsParserFactory 
{
	public static IGkFsParser createParser()
	{
		return new GkFsParser();
	}
	
	public static IGkFsParserSearchLocation createSearchLocation(String name, String path, int depth)
	{
		return new GkFsParserSearchLocation(name, path, depth);
	}
	
}
