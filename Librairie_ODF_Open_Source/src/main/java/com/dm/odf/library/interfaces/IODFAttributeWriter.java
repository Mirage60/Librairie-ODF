package com.dm.odf.library.interfaces;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.interfaces.xml.IODFXmlWriter;

public interface IODFAttributeWriter extends IODFXmlWriter
{

	public ODF_ATTRIBUTE_ID   getAttributeID();
	public IODFAttributeValue getValue();

}
