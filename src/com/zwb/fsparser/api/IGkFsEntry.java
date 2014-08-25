package com.zwb.fsparser.api;

import java.io.File;
import java.io.Serializable;

public interface IGkFsEntry extends Comparable<IGkFsEntry>
{
	public String getPath();
	public String getFilename();
	public File getFile();
	public String getArtistName();
	public String getReleaseName();
}
