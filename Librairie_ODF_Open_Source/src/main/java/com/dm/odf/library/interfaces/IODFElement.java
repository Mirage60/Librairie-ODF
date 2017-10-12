package com.dm.odf.library.interfaces;

import java.net.URL;

import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;

public interface IODFElement
{

	public ODF_NAMESPACE_ID getNamespaceID();
	public URL              getNamespaceURL();
	public ODF_ELEMENT_ID   getElementID();
	public String           getLocalName();

}
