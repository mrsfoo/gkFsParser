package com.zwb.fsparser.impl;

import com.zwb.fsparser.api.IGkFsParserQuery;

public class GkFsParserQuery implements IGkFsParserQuery
{
	private String path;
	private int depth;

	public GkFsParserQuery(String path, int depth)
	{
		this.path = path;
		this.depth = depth;
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

}
