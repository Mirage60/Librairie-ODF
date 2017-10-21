package com.dm.odf.library.interfaces.elements;

import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElement;

public interface IODFStyleFootnoteSepElement extends IODFElement
{

	public IODFAttributeValue getWidth();
	public IODFAttributeValue getDdistanceBeforeSeparator();
	public IODFAttributeValue getDistanceAfterSeparator();
	public IODFAttributeValue getLineStyle();
	public IODFAttributeValue getAdjustment();
	public IODFAttributeValue getRelativeWidth();
	public IODFAttributeValue getColor();

}
