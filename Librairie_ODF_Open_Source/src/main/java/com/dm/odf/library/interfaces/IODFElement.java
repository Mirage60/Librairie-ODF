package com.dm.odf.library.interfaces;

import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;

public interface IODFElement
{

	public ODF_ELEMENT_ID getElementID();
	public String         getLocalName();

}
