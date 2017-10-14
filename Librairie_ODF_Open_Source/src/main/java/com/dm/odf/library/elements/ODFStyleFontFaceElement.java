package com.dm.odf.library.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFAttributeValue;
import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFElement;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFNode;
import com.dm.odf.library.interfaces.IODFStyleFontFaceElement;

public abstract class ODFStyleFontFaceElement extends ODFElement implements IODFStyleFontFaceElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	private ODFStyleFontFaceElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFAttributeValue getStyleName();

	@Override
	public abstract IODFAttributeValue getFontFamily();

	@Override
	public abstract IODFAttributeValue getFontFamilyGeneric();

	@Override
	public abstract IODFAttributeValue getFontPitch();

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

	public static final IODFStyleFontFaceElement newInstance(final String styleName,final String fontFamily,final String fontFamilyGeneric,final String fontPitch)
	{

		return new ODFStyleFontFaceElement()
		{

			@Override
			public final IODFAttributeValue getStyleName()
			{

				return (styleName == null ? "" : styleName.trim()).length() == 0 ? null : ODFAttributeValue.newInstance(styleName.trim());

			}

			@Override
			public final IODFAttributeValue getFontFamily()
			{

				return (fontFamily == null ? "" : fontFamily.trim()).length() == 0 ? null : ODFAttributeValue.newInstance(fontFamily.trim());

			}

			@Override
			public final IODFAttributeValue getFontFamilyGeneric()
			{

				return (fontFamilyGeneric == null ? "" : fontFamilyGeneric.trim()).length() == 0 ? null : ODFAttributeValue.newInstance(fontFamilyGeneric.trim());

			}

			@Override
			public final IODFAttributeValue getFontPitch()
			{

				return (fontPitch == null ? "" : fontPitch.trim()).length() == 0 ? null : ODFAttributeValue.newInstance(fontPitch.trim());

			}

		};

	}

	public static final IODFStyleFontFaceElement newInstance(final String styleName,final String fontFamily)
	{

		return newInstance(styleName,fontFamily,"","");

	}

}
