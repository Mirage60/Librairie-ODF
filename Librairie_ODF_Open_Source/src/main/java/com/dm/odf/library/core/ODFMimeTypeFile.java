package com.dm.odf.library.core;

import com.dm.odf.library.interfaces.IODFDocument;
import com.dm.odf.library.interfaces.IODFMimeTypeFile;

public abstract class ODFMimeTypeFile implements IODFMimeTypeFile
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFMimeTypeFile()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFDocument getDocument();

}
