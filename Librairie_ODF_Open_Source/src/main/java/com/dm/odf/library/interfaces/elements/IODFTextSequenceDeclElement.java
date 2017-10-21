package com.dm.odf.library.interfaces.elements;

import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElement;

public interface IODFTextSequenceDeclElement extends IODFElement
{

	public IODFAttributeValue getTextName();
	public IODFAttributeValue getDisplayOutlineLevel();

}
