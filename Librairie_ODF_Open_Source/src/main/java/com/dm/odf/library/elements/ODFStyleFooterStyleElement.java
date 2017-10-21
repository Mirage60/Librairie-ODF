package com.dm.odf.library.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFElement;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFNode;
import com.dm.odf.library.interfaces.elements.IODFStyleFooterStyleElement;

public abstract class ODFStyleFooterStyleElement extends ODFElement implements IODFStyleFooterStyleElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFStyleFooterStyleElement()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.STYLE_FOOTER_STYLE;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
	{

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes()
	{

		return Collections.unmodifiableList(new ArrayList<>());

	}

}
