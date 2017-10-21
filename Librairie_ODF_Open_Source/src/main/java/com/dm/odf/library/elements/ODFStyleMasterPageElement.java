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
import com.dm.odf.library.interfaces.elements.IODFStyleMasterPageElement;

public abstract class ODFStyleMasterPageElement extends ODFElement implements IODFStyleMasterPageElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFStyleMasterPageElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFAttributeValue getMasterName();

	@Override
	public abstract IODFAttributeValue getPageLayoutName();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.STYLE_MASTER_PAGE;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
	{

		final IODFAttributeValue masterName     = this.getMasterName();
		final IODFAttributeValue pageLayoutName = this.getPageLayoutName();

		if (masterName     == null) throw new Exception("Failed to retrieve master name value"     );
		if (pageLayoutName == null) throw new Exception("Failed to retrieve page layout name value");

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		attributes.put(ODF_ATTRIBUTE_ID.STYLE_NAME             ,masterName    );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_PAGE_LAYOUT_NAME ,pageLayoutName);

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes()
	{

		return Collections.unmodifiableList(new ArrayList<>());

	}

}
