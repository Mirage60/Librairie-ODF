package com.dm.odf.library.interfaces;

import java.net.URL;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;

public interface IODFElement extends IODFNode
{

	public ODF_NAMESPACE_ID             getNamespaceID();
	public URL                          getNamespaceURL();
	public ODF_ELEMENT_ID               getElementID();
	public String                       getPrefix();
	public String                       getLocalName();
	public String                       getName();
	public Map<ODF_ATTRIBUTE_ID,String> getAttributeMap();
	public List<IODFAttribute>          getAttributes();
	public List<IODFNode>               getNodes();

}
