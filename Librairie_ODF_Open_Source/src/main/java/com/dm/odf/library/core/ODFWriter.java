package com.dm.odf.library.core;

import java.io.OutputStreamWriter;

import com.dm.odf.library.interfaces.IODFWriter;

public abstract class ODFWriter implements IODFWriter
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFWriter()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract void write(final OutputStreamWriter writer) throws Exception;

}
