package com.dm.odf.library.interfaces;

import java.io.File;

import javax.activation.MimeType;

public interface IODFContent
{

	// Accesseurs en lecture

	public MimeType getMimeType();
	public byte[]   getData();

	// M�thodes

	public void save(File file) throws Exception;

}
