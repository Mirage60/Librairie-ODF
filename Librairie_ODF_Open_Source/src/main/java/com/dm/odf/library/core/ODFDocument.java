package com.dm.odf.library.core;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE;
import com.dm.odf.library.interfaces.IODFContentFile;
import com.dm.odf.library.interfaces.IODFDocument;
import com.dm.odf.library.interfaces.IODFMimeTypeFile;

public abstract class ODFDocument implements IODFDocument
{

	private final IODFContentFile contentFile = new ODFContentFile()
	{

		@Override
		public final IODFDocument getDocument()
		{

			return ODFDocument.this;

		}

	};

	private final IODFMimeTypeFile mimeTypeFile = new ODFMimeTypeFile()
	{

		@Override
		public final IODFDocument getDocument()
		{

			return ODFDocument.this;

		}

	};

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFDocument()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_DOCUMENT_TYPE getDocumentType();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final IODFContentFile getContentFile()
	{

		return this.contentFile;

	}

	@Override
	public final IODFMimeTypeFile getMimeTypeFile()
	{

		return this.mimeTypeFile;

	}

}
