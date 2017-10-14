package com.dm.odf.library.interfaces;

import java.io.OutputStreamWriter;
import java.net.URL;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;

public interface IODFAttribute
{

	// Accesseur en lecture

	public ODF_NAMESPACE_ID    getNamespaceID();
	public URL                 getNamespaceURL();
	public ODF_ATTRIBUTE_ID    getAttributeID();
	public String              getPrefix();
	public String              getLocalName();
	public String              getName();
	public IODFAttributeValue  getValue();
	public IODFAttributeWriter getWriter();

	// Méthodes

	public void write(OutputStreamWriter writer) throws Exception;

}
