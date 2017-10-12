package com.dm.odf.library.core;

import java.net.URL;

import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;
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
	public final ODF_NAMESPACE_ID getNamespaceID()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		return elementID == null ? null : elementID.getNamespaceID();

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

		final ODF_ELEMENT_ID elementID = this.getElementID();

		final String localName = elementID == null ? "" : elementID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

}
