package com.dm.odf.library.interfaces.elements;

import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElement;

public interface IODFStyleMasterPageElement extends IODFElement
{

	public IODFAttributeValue getMasterName();
	public IODFAttributeValue getPageLayoutName();

}
