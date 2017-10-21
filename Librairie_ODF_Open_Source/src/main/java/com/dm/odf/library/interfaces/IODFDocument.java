package com.dm.odf.library.interfaces;

import java.io.File;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;
import com.dm.odf.library.interfaces.parts.IODFContentFile;
import com.dm.odf.library.interfaces.parts.IODFMetaFile;
import com.dm.odf.library.interfaces.parts.IODFMimeTypeFile;
import com.dm.odf.library.interfaces.parts.IODFSettingsFile;
import com.dm.odf.library.interfaces.parts.IODFStylesFile;

public interface IODFDocument
{

	// Accesseurs en lecture

	public ODF_DOCUMENT_TYPE_ID getDocumentTypeID();
	public ODF_MIME_TYPE_ID     getMimeTypeID();
	public MimeType             getMimeType();
	public IODFMimeTypeFile     getMimeTypeFile();
	public IODFContentFile      getContentFile();
	public IODFStylesFile       getStylesFile();
	public IODFMetaFile         getMetaFile();
	public IODFSettingsFile     getSettingsFile();
	public IODFContent          getContent();

	// Méthodes

	public void save(File file) throws Exception;

}
