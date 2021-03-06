package com.dm.odf.library.core;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;
import com.dm.odf.library.interfaces.IODFTextDocument;

public final class ODFTextDocument extends ODFDocument implements IODFTextDocument
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	public ODFTextDocument()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_DOCUMENT_TYPE_ID getDocumentTypeID()
	{

		return ODF_DOCUMENT_TYPE_ID.TEXT;

	}

}
