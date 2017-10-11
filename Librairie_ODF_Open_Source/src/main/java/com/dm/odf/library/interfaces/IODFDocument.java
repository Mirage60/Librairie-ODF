package com.dm.odf.library.interfaces;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE;

public interface IODFDocument
{

	public ODF_DOCUMENT_TYPE getDocumentType();
	public IODFMimeTypeFile  getMimeTypeFile();
	public IODFContentFile   getContentFile();

}
