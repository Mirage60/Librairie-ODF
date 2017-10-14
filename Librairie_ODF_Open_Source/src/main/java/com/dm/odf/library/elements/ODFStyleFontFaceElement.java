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

public abstract class ODFStyleFontFaceElement extends ODFElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFStyleFontFaceElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	protected abstract IODFAttributeValue getStyleName();
	protected abstract IODFAttributeValue getFontFamily();
	protected abstract IODFAttributeValue getFontFamilyGeneric();
	protected abstract IODFAttributeValue getFontPitch();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.STYLE_FONT_FACE;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
	{

		final IODFAttributeValue styleName         = this.getStyleName();
		final IODFAttributeValue fontFamily        = this.getFontFamily();
		final IODFAttributeValue fontFamilyGeneric = this.getFontFamilyGeneric();
		final IODFAttributeValue fontPitch         = this.getFontPitch();

		if (styleName  == null) throw new Exception("Failed to retrieve style name" );
		if (fontFamily == null) throw new Exception("Failed to retrieve font family");

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		attributes.put(ODF_ATTRIBUTE_ID.STYLE_NAME      ,styleName );
		attributes.put(ODF_ATTRIBUTE_ID.SVG_FONT_FAMILY ,fontFamily);

		if (fontFamilyGeneric != null)
		{

			attributes.put(ODF_ATTRIBUTE_ID.STYLE_FONT_FAMILY_GENERIC,fontFamilyGeneric);

		}

		if (fontPitch != null)
		{

			attributes.put(ODF_ATTRIBUTE_ID.STYLE_FONT_PITCH,fontPitch);

		}

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes()
	{

		return Collections.unmodifiableList(new ArrayList<>());

	}

}
