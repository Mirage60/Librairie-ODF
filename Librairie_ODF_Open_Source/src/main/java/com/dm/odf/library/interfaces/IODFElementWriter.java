package com.dm.odf.library.interfaces;

import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;

public interface IODFElementWriter extends IODFWriter
{

	public ODF_ELEMENT_ID                           getElementID();
	public Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception;
	public List<IODFNode>                           getNodes() throws Exception;

}
