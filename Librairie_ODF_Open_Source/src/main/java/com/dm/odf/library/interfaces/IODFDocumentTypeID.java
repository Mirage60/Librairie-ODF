package com.dm.odf.library.interfaces;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;

public interface IODFDocumentTypeID
{

	public ODF_MIME_TYPE_ID getMimeTypeID();
	public MimeType         getMimeType();

}
