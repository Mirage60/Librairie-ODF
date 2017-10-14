package com.dm.odf.library.core;

import java.io.OutputStreamWriter;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElementWriter;
import com.dm.odf.library.interfaces.IODFNode;

public abstract class ODFElementWriter extends ODFWriter implements IODFElementWriter
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFElementWriter()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_ELEMENT_ID getElementID();

	@Override
	public abstract Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception;

	@Override
	public abstract List<IODFNode> getNodes() throws Exception;

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
