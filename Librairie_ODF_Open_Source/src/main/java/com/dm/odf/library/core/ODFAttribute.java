package com.dm.odf.library.core;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.interfaces.IODFAttribute;

public abstract class ODFAttribute implements IODFAttribute
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFAttribute()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_ATTRIBUTE_ID getAttributeID();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final String getLocalName()
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		final String localName = attributeID == null ? "" : attributeID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

}
