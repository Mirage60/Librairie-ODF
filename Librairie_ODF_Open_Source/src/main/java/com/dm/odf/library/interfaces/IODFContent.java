package com.dm.odf.library.interfaces;

import java.io.File;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;

public interface IODFContent
{

	// Accesseurs en lecture

	public ODF_MIME_TYPE_ID getMimeTypeID();
	public MimeType         getMimeType();
	public byte[]           getData() throws Exception;

	// Méthodes

	public void save(File file) throws Exception;

}
