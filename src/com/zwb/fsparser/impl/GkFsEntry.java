package com.zwb.fsparser.impl;

import java.io.File;
import java.text.StringCharacterIterator;

import com.zwb.fsparser.api.IGkFsEntry;
import com.zwb.fsparser.exception.GkFsParserRuntimeExceptionIllegalFolderName;
import com.zwb.geekology.parser.impl.GkParserQueryArtist;
import com.zwb.geekology.parser.impl.util.GkParserStringUtils;
import com.zwb.lazyload.ILoader;
import com.zwb.lazyload.LazyLoader;
import com.zwb.lazyload.Ptr;

public class GkFsEntry implements IGkFsEntry
{
    private File file;
    private Ptr<String> artistNameSantized = new Ptr<String>();
    private Ptr<String> releaseNameSantized = new Ptr<String>();
    
    public GkFsEntry(String path)
    {
	this.file = new File(path);
	if (!this.file.exists())
	{
	    throw new GkFsParserRuntimeExceptionIllegalFolderName("file for path <" + path + "> doesn't exist");
	}
    }
    
    public GkFsEntry(File file)
    {
	this.file = file;
    }
    
    @Override
    public String getPath()
    {
	return this.getFile().getAbsolutePath();
    }
    
    @Override
    public String getFilename()
    {
	return this.getFile().getName();
    }
    
    @Override
    public File getFile()
    {
	return this.file;
    }
    
    @Override
    public String getArtistName()
    {
	String fn = this.getFile().getName();
	if (!Util.checkFolderName(fn))
	{
	    throw new GkFsParserRuntimeExceptionIllegalFolderName("illegal folder name: " + fn);
	}
	return fn.substring(0, fn.indexOf(Config.SEPARATOR)).trim();
    }
    
    @Override
    public String getReleaseName()
    {
	String fn = this.getFile().getName();
	if (!Util.checkFolderName(fn))
	{
	    throw new GkFsParserRuntimeExceptionIllegalFolderName("illegal folder name: " + fn);
	}
	return fn.substring(fn.indexOf(Config.SEPARATOR) + 1, fn.length()).trim();
    }
    
    @Override
    public int compareTo(IGkFsEntry o)
    {
	return this.getArtistName().compareTo(o.getArtistName());
    }
    
    @Override
    public boolean equals(Object o)
    {
	if (o == null)
	{
	    return false;
	}
	if (!o.getClass().equals(this.getClass()))
	{
	    return false;
	}
	return this.getPath().equals(((GkFsEntry) o).getPath());
    }
    
    @Override
    public int hashCode()
    {
	return this.getPath().hashCode();
    }
    
    @Override
    public boolean isSampler()
    {
	return this.getArtistName().equals(Config.SAMPLER_STARTER);
    }
    
    public String toString()
    {
	return "fsentry <" + this.getPath() + ">: <artist=" + this.getArtistName() + ">/<release=" + this.getReleaseName() + ">";
    }
    
    @Override
    public String getArtistNameSantised()
    {
	return GkParserStringUtils.getGeneralArtistNameFilters().filter(this.getArtistName(), true);
    }
    
    @Override
    public String getReleaseNameSantised()
    {
	return GkParserStringUtils.getGeneralReleaseNameFilters(this.getArtistName()).filter(this.getReleaseName(), true);
    }
}
