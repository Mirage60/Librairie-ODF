package com.dm.odf.library.core;

import com.dm.odf.library.interfaces.IODFContentFile;
import com.dm.odf.library.interfaces.IODFDocument;

public abstract class ODFContentFile implements IODFContentFile
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFContentFile()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	public abstract IODFDocument getDocument();

}
