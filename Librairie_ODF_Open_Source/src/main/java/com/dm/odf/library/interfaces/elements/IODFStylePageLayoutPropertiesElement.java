package com.dm.odf.library.interfaces.elements;

import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElement;

public interface IODFStylePageLayoutPropertiesElement extends IODFElement
{

	public IODFAttributeValue          getPageWidth();
	public IODFAttributeValue          getPageHeight();
	public IODFAttributeValue          getNumericFormat();
	public IODFAttributeValue          getPrintOrientation();
	public IODFAttributeValue          getMarginLeft();
	public IODFAttributeValue          getMargintop();
	public IODFAttributeValue          getMarginRight();
	public IODFAttributeValue          getMarginBottom();
	public IODFAttributeValue          getWritingMode();
	public IODFAttributeValue          getFootnoteMaxHeight();
	public IODFStyleFootnoteSepElement getFootnoteSeparator();

}
