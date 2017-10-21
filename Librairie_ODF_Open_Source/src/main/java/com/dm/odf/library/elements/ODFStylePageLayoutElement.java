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
import com.dm.odf.library.interfaces.elements.IODFStyleHeaderStyleElement;
import com.dm.odf.library.interfaces.elements.IODFStylePageLayoutElement;
import com.dm.odf.library.interfaces.elements.IODFStylePageLayoutPropertiesElement;

public abstract class ODFStylePageLayoutElement extends ODFElement implements IODFStylePageLayoutElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFStylePageLayoutElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFAttributeValue getLayoutName();

	@Override
	public abstract IODFStylePageLayoutPropertiesElement getPageLayoutProperties();

	@Override
	public abstract IODFStyleHeaderStyleElement getHeaderStyle();

	@Override
	public abstract IODFStyleFooterStyleElement getFooterStyle();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.STYLE_PAGE_LAYOUT;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
	{

		final IODFAttributeValue layoutName = this.getLayoutName();

		if (layoutName == null) throw new Exception("Failed to retrieve page layout name value");

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		attributes.put(ODF_ATTRIBUTE_ID.STYLE_NAME,layoutName);

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes() throws Exception
	{

		final IODFStylePageLayoutPropertiesElement layoutProperties = this.getPageLayoutProperties();
		final IODFStyleHeaderStyleElement          headerStyle      = this.getHeaderStyle();
		final IODFStyleFooterStyleElement          footerStyle      = this.getFooterStyle();

		if (layoutProperties == null) throw new Exception("Failed to retrieve layout properties");
		if (headerStyle      == null) throw new Exception("Failed to retrieve header style"     );
		if (footerStyle      == null) throw new Exception("Failed to retrieve footer style"     );

		final List<IODFNode> nodes = new ArrayList<>();

		nodes.add(layoutProperties);
		nodes.add(headerStyle     );
		nodes.add(footerStyle     );

		return Collections.unmodifiableList(nodes);

	}

}
