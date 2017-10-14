package com.dm.odf.library.interfaces;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_PART_FILE_ID;

public interface IODFPartFile
{

	public ODF_PART_FILE_ID     getPartFileID();
	public IODFDocument         getDocument();
	public ODF_DOCUMENT_TYPE_ID getDocumentTypeID();
	public String               getFileName();
	public IODFContent          getContent();

}
