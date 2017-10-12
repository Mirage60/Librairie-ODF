package com.dm.odf.library.interfaces;

import java.net.URL;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;

public interface IODFAttribute
{

	public ODF_NAMESPACE_ID getNamespaceID();
	public URL              getNamespaceURL();
	public ODF_ATTRIBUTE_ID getAttributeID();
	public String           getLocalName();

}
