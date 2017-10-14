package com.dm.odf.library.interfaces;

import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;

public interface IODFElement extends IODFNode
{

	public ODF_NAMESPACE_ID                         getNamespaceID();
	public String                                   getNamespaceURL();
	public ODF_ELEMENT_ID                           getElementID();
	public String                                   getPrefix();
	public String                                   getLocalName();
	public String                                   getName();
	public Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception;
	public List<IODFAttribute>                      getAttributes() throws Exception;
	public List<IODFNode>                           getNodes() throws Exception;

}
