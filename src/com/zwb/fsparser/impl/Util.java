package com.zwb.fsparser.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Util
{
    public static final String ERROR_DESC_FOLDER_NAME = "Illegally formatted folder name";
    public static final String ERROR_DESC_FILE = "Path is not a folder";
    
    public static boolean checkFolderName(String folderName)
    {
	if ((folderName == null) || (folderName.isEmpty()))
	{
	    return false;
	}
	if (!folderName.contains(Config.SEPARATOR))
	{
	    return false;
	}
	return true;
    }
    
    public static boolean checkFile(File f)
    {
	if (f == null)
	{
	    return false;
	}
	
	if (!f.isDirectory())
	{
	    return false;
	}
	return true;
    }
    
    public static List<String> getFilenameList(List<File> files)
    {
	List<String> list = new ArrayList<>();
	for (File f : files)
	{
	    list.add(f.getName());
	}
	return list;
    }
    
    public static List<String> getPathList(List<File> files)
    {
	List<String> list = new ArrayList<>();
	for (File f : files)
	{
	    list.add(f.getAbsolutePath());
	}
	return list;
    }
    
    public static List<File> getFileList(List<String> filenames)
    {
	List<File> list = new ArrayList<>();
	for (String s : filenames)
	{
	    list.add(new File(s));
	}
	return list;
    }
    
    public static List<File> getFsLeaves(String rootFolderPath, int depth, boolean filter, Map<File, String> errors)
    {
	return getFsLeaves(new File(rootFolderPath), depth, filter, errors);
    }
    
    public static List<File> getFsLeaves(File rootFolder, int depth, boolean filter, Map<File, String> errors)
    {
	List<File> filesToWork = new ArrayList<File>();
	List<File> resultFiles = new ArrayList<File>();
	filesToWork.add(rootFolder);
	for (int i = 0; i < depth; i++)
	{
	    resultFiles.clear();
	    for (File f : filesToWork)
	    {
		if (f.isDirectory())
		{
		    resultFiles.addAll(Arrays.asList(f.listFiles()));
		}
	    }
	    filesToWork.clear();
	    filesToWork.addAll(resultFiles);
	}
	if (filter)
	{
	    return filterFiles(filesToWork, errors);
	}
	else
	{
	    return filesToWork;
	}
    }
    
    public static List<File> filterFiles(List<File> files, Map<File, String> errors)
    {
	List<File> ret = new ArrayList<>();
	for (File f : files)
	{
	    if (!checkFile(f))
	    {
		if (errors != null)
		{
		    errors.put(f, ERROR_DESC_FILE);
		}
		continue;
	    }
	    if (!checkFolderName(f.getName()))
	    {
		errors.put(f, ERROR_DESC_FOLDER_NAME);
		continue;
	    }
	    ret.add(f);
	}
	return ret;
    }
    
}
