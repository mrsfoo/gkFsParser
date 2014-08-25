package com.zwb.fsparser.api;

import java.util.Collection;

public interface IGkFsParser 
{
	public IGkFsParserResult parseFolders(IGkFsParserSearchLocation... searchLocs);
	public IGkFsParserResult parseFolders(Collection<IGkFsParserSearchLocation> searchLocs);
	
}
