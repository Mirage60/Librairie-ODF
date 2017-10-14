package com.dm.odf.library.core;

import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElementWriter;
import com.dm.odf.library.interfaces.IODFNode;

public abstract class ODFElementWriter extends ODFWriter implements IODFElementWriter
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFElementWriter()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_ELEMENT_ID getElementID();

	@Override
	public abstract Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception;

	@Override
	public abstract List<IODFNode> getNodes() throws Exception;

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final void write(final OutputStreamWriter writer) throws Exception
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		if (elementID == null) throw new Exception("Failed to retrieve ODF element ID");

		String name = elementID.getName();

		name = name == null ? "" : name.trim();

		if ("".equals(name)) throw new Exception("Undefined name for ODF attribute ID [" + elementID.name() + "]");

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = this.getAttributeMap();

		final List<IODFNode> nodes = this.getNodes();

		// Sérialisation

		if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

		try
		{

			writer.write("<" + name);

			if ((attributes == null ? 0 : attributes.size()) > 0)
			{

				final Set<ODF_ATTRIBUTE_ID> keySet = attributes.keySet();

				final Iterator<ODF_ATTRIBUTE_ID> iterator = keySet == null ? null : keySet.iterator();

				while (iterator == null ? false : iterator.hasNext())
				{

					final ODF_ATTRIBUTE_ID attributeID = iterator.next();

					if (attributeID == null) throw new Exception("Failed to retrieve ODF attribute ID");

					final IODFAttributeValue value = attributes.get(attributeID);

					if (value == null) throw new Exception("Failed to retrieve value for ODF attribute ID [" + attributeID.name() + "]");

					new ODFAttributeWriter()
					{

						@Override
						public final ODF_ATTRIBUTE_ID getAttributeID()
						{

							return attributeID;

						}

						@Override
						public final IODFAttributeValue getValue()
						{

							return value;

						}

					}.write(writer);

				}

			}

			if ((nodes == null ? 0 : nodes.size()) > 0)
			{

				writer.write(">");

				try
				{

					for (final IODFNode node : nodes)
					{

						if (node == null) throw new Exception("Invalid ODF node");

						node.write(writer);

					}

				}
				finally
				{

					writer.write("</" + name + ">");

				}

			}
			else
			{

				writer.write("/>");

			}

		}
		finally
		{

			writer.flush();

		}

	}

}
