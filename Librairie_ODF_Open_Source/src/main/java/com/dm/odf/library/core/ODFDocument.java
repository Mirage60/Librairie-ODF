package com.dm.odf.library.core;

import com.dm.odf.library.interfaces.IODFContentFile;
import com.dm.odf.library.interfaces.IODFDocument;
import com.dm.odf.library.interfaces.IODFMimeTypeFile;

public final class ODFDocument implements IODFDocument
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

	public ODFDocument()
	{

		super();

	}

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
