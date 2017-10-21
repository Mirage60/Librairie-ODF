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
import com.dm.odf.library.interfaces.elements.IODFTextParagraphElement;

public abstract class ODFTextParagraphElement extends ODFElement implements IODFTextParagraphElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFTextParagraphElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	protected abstract IODFAttributeValue getStyleName();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.TEXT_P;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
	{

		final IODFAttributeValue styleName = this.getStyleName();

		if (styleName == null) throw new Exception("Failed to retrieve style name");

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		attributes.put(ODF_ATTRIBUTE_ID.TEXT_STYLE_NAME,styleName );

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes()
	{

		return Collections.unmodifiableList(new ArrayList<>());

	}

}
