package com.dm.odf.library.interfaces.elements;

import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElement;

public interface IODFStylePageLayoutElement extends IODFElement
{

	public IODFAttributeValue                   getLayoutName();
	public IODFStylePageLayoutPropertiesElement getPageLayoutProperties();
	public IODFStyleHeaderStyleElement          getHeaderStyle();
	public IODFStyleFooterStyleElement          getFooterStyle();

}
