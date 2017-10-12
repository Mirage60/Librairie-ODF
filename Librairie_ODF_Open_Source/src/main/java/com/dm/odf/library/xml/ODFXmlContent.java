package com.dm.odf.library.xml;

import java.io.OutputStreamWriter;

import com.dm.odf.library.core.ODFTextContent;
import com.dm.odf.library.interfaces.IODFXmlContent;

public abstract class ODFXmlContent extends ODFTextContent implements IODFXmlContent
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFXmlContent()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	protected final void write(final OutputStreamWriter writer) throws Exception
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
