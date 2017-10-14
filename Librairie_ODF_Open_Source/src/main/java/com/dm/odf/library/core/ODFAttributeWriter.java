package com.dm.odf.library.core;

import java.io.OutputStreamWriter;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFAttributeWriter;
import com.dm.odf.library.xml.ODFXmlWriter;

public abstract class ODFAttributeWriter extends ODFXmlWriter implements IODFAttributeWriter
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFAttributeWriter()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_ATTRIBUTE_ID getAttributeID();

	@Override
	public abstract IODFAttributeValue getValue();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final void write(final OutputStreamWriter writer) throws Exception
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		if (attributeID == null) throw new Exception("Failed to retrieve ODF attribute ID");

		String name = attributeID.getName();

		name = name == null ? "" : name.trim();

		if ("".equals(name)) throw new Exception("Undefined name for ODF attribute ID [" + attributeID.name() + "]");

		final IODFAttributeValue value = this.getValue();

		if (value == null) throw new Exception("Failed to retrieve ODF attribute value");

		String valueStr = value.format();

		valueStr = valueStr == null ? "" : valueStr.trim();

		// Sérialisation

		if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

		try
		{

			writer.write(" "               );  // << IMPERATIF
			writer.write(strToXml(name)    );
			writer.write("=\""             );
			writer.write(strToXml(valueStr));
			writer.write("\""              );

		}
		finally
		{

			writer.flush();

		}

	}

}
