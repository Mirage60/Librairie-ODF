package com.dm.odf.library.core;

import com.dm.odf.library.interfaces.IODFContentFile;
import com.dm.odf.library.interfaces.IODFDocument;

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

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFDocument()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	public final IODFContentFile getContentFile()
	{

		return this.contentFile;

	}

}
