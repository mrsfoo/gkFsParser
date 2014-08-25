package com.zwb.fsparser.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util 
{
	public static boolean checkFolderName(String folderName)
	{
		if((folderName==null) || (folderName.isEmpty()))
		{
			return false;			
		}
		if(!folderName.contains(Config.separator))
		{
			return false;
		}
		return true;
	}
	
	public static boolean checkFile(File f)
	{
		if(f==null)
		{
			return false;
		}
		
		if(!f.isDirectory())
		{
			return false;
		}
		return true;
	}
	
	public static List<String> getFilenameList(List<File> files)
	{
		List<String> list = new ArrayList<>();
		for(File f: files)
		{
			list.add(f.getName());
		}
		return list;
	}
	
	public static List<String> getPathList(List<File> files)
	{
		List<String> list = new ArrayList<>();
		for(File f: files)
		{
			list.add(f.getAbsolutePath());
		}
		return list;
	}
	
	public static List<File> getFileList(List<String> filenames)
	{
		List<File> list = new ArrayList<>();
		for(String s: filenames)
		{
			list.add(new File(s));
		}
		return list;
	}
	
	public static List<File> getFsLeaves(String rootFolderPath, int depth, boolean filter)
	{
		return getFsLeaves(new File(rootFolderPath), depth, filter);
	}

	public static List<File> getFsLeaves(File rootFolder, int depth, boolean filter)
	{
		List<File> filesToWork = new ArrayList<File>();
		List<File> resultFiles = new ArrayList<File>();
		filesToWork.add(rootFolder);
		for(int i=-1; i<depth; i++)
		{
			resultFiles.clear();
			for(File f: filesToWork)
			{
				if(f.isDirectory())
				{
					resultFiles.addAll(Arrays.asList(f.listFiles()));
				}
			}
			filesToWork.clear();
			filesToWork.addAll(resultFiles);
		}
		if(filter)
		{
			return filterFiles(filesToWork);
		}
		else
		{
			return filesToWork;
		}
	}
	
	public static List<File> filterFiles(List<File> files)
	{
		List<File> ret = new ArrayList<>();
		for(File f: files)
		{
			if(!checkFile(f))
			{
				continue;
			}
			if(!checkFolderName(f.getName()))
			{
				continue;
			}
			ret.add(f);
		}
		return ret;
	}
	

}