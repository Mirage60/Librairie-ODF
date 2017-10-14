package com.dm.odf.library.core;

import java.io.OutputStreamWriter;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFAttributeWriter;

public abstract class ODFAttributeWriter extends ODFWriter implements IODFAttributeWriter
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFAttributeWriter()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_ATTRIBUTE_ID getAttributeID();

	@Override
	public abstract IODFAttributeValue getValue();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final void write(final OutputStreamWriter writer) throws Exception
	{

		// Sérialisation

		if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

		try
		{

		}
		finally
		{

			writer.flush();

		}

	}

}
