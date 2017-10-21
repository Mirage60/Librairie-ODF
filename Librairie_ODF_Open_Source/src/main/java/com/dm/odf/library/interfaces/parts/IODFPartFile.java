package com.dm.odf.library.interfaces.parts;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_PART_FILE_ID;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFDocument;

public interface IODFPartFile
{

	public ODF_PART_FILE_ID     getPartFileID();
	public IODFDocument         getDocument();
	public ODF_DOCUMENT_TYPE_ID getDocumentTypeID();
	public String               getFileName();
	public String               getEntryName();
	public IODFContent          getContent();

}
