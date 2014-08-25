package com.zwb.fsparser.junit;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;

import com.zwb.fsparser.api.IGkFsEntry;
import com.zwb.fsparser.api.IGkFsParser;
import com.zwb.fsparser.api.IGkFsParserSearchLocation;
import com.zwb.fsparser.api.IGkFsParserResult;
import com.zwb.fsparser.impl.GkFsParser;
import com.zwb.fsparser.impl.GkFsParserSearchLocation;
import com.zwb.fsparser.impl.Util;

public class FsParserTest extends TestCase
{
	String root = "c:\\zwb\\geekOlogy\\bsp";
	
	public void testDeepening()
	{
		List<Integer> expected = Arrays.asList(4, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		for(int i=0; i<10; i++)
		{
			int depth = i;
			List<File> files = Util.getFsLeaves(root, depth, true);
			List<String> filenames = Util.getFilenameList(files);
			System.out.println("Leaves of <"+root+"> with depth <"+depth+">: SIZE==<"+filenames.size()+">");
			for(String s: filenames)
			{
				System.out.println("* <"+s+">");
			}
			System.out.println("\n");			
			assertEquals(expected.get(i).intValue(), files.size());
		}
	}	
	
	public void testParser0()
	{
		IGkFsParser parser = new GkFsParser();
		List<Integer> expected = Arrays.asList(4, 12, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		for(int i=0; i<10; i++)
		{
			int depth = i;
			IGkFsParserSearchLocation query = new GkFsParserSearchLocation("<name>", root, depth);
			IGkFsParserResult result = parser.parseFolders(query);
			List<IGkFsEntry> entries = result.getEntries();
			System.out.println("Leaves of <"+root+"> with depth <"+depth+">: SIZE==<"+entries.size()+">");
			for(IGkFsEntry e: entries)
			{
				System.out.println("* <"+e.getFilename()+">: <"+e.getArtistName()+">/<"+e.getReleaseName()+">");
			}
			System.out.println("\n");			
			assertEquals(expected.get(i).intValue(), entries.size());
		}
	}	

	public void testParser1()
	{
		IGkFsParser parser = new GkFsParser();
		List<IGkFsParserSearchLocation> queries = new ArrayList<>();
		for(int i=0; i<10; i++)
		{
			int depth = i;
			IGkFsParserSearchLocation query = new GkFsParserSearchLocation("<name>", root, depth);
			queries.add(query);
		}
		IGkFsParserResult result = parser.parseFolders(queries);
		List<IGkFsEntry> entries = result.getEntries();
		Collections.sort(entries);
		System.out.println("Leaves of <"+root+">: SIZE==<"+entries.size()+">");
		for(IGkFsEntry e: entries)
		{
			System.out.println("* <"+e.getFilename()+">: <"+e.getArtistName()+">/<"+e.getReleaseName()+">");
		}
		System.out.println("\n");			
		assertEquals(28, entries.size());
	}	

}
