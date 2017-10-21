package com.dm.odf.library.interfaces.elements;

import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElement;

public interface IODFStyleFontFaceElement extends IODFElement
{

	public IODFAttributeValue getStyleName();
	public IODFAttributeValue getFontFamily();
	public IODFAttributeValue getFontFamilyGeneric();
	public IODFAttributeValue getFontPitch();

}
