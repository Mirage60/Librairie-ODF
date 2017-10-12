package com.dm.odf.library.interfaces;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;

public interface IODFAttribute
{

	public ODF_ATTRIBUTE_ID getAttributeID();
	public String           getLocalName();

}
