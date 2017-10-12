package com.dm.odf.library.core;

import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.interfaces.IODFElement;

public abstract class ODFElement implements IODFElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_ELEMENT_ID getElementID();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final String getLocalName()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		final String localName = elementID == null ? "" : elementID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

}
