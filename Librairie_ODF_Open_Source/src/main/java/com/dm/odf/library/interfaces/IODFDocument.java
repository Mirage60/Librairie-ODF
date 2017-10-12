package com.dm.odf.library.interfaces;

import java.io.File;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;

public interface IODFDocument
{

	// Accesseurs en lecture

	public ODF_DOCUMENT_TYPE_ID getDocumentTypeID();
	public MimeType             getMimeType();
	public IODFMimeTypeFile     getMimeTypeFile();
	public IODFContentFile      getContentFile();
	public IODFStylesFile       getStylesFile();
	public IODFContent          getContent();

	// Méthodes

	public void save(File file) throws Exception;

}
