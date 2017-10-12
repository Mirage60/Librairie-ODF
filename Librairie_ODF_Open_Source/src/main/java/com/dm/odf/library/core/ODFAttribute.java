package com.dm.odf.library.core;

import java.net.URL;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;
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
	public final ODF_NAMESPACE_ID getNamespaceID()
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		return attributeID == null ? null : attributeID.getNamespaceID();

	}

	@Override
	public final URL getNamespaceURL()
	{

		final ODF_NAMESPACE_ID namespaceID = this.getNamespaceID();

		return namespaceID == null ? null : namespaceID.getURL();

	}

	@Override
	public final String getLocalName()
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		final String localName = attributeID == null ? "" : attributeID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

}
