package com.dm.odf.library.interfaces;

import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;

public interface IODFAttributeID
{

	public ODF_NAMESPACE_ID getNamespaceID();
	public String           getLocalName();

}
