package com.dm.odf.library.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;
import com.dm.odf.library.interfaces.IODFAttribute;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFElement;
import com.dm.odf.library.interfaces.IODFElementWriter;
import com.dm.odf.library.interfaces.IODFNode;

public abstract class ODFElement extends ODFNode implements IODFElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFElement()
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
	public final ODF_NAMESPACE_ID getNamespaceID()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		return elementID == null ? null : elementID.getNamespaceID();

	}

	@Override
	public final String getPrefix()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		final String prefix = elementID == null ? null : elementID.getPrefix();

		return prefix == null ? "" : prefix.trim();

	}

	@Override
	public final String getElementName()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		final String name = elementID == null ? null : elementID.getElementName();

		return name == null ? "" : name.trim();

	}

	@Override
	public final String getNamespaceURL()
	{

		final ODF_NAMESPACE_ID namespaceID = this.getNamespaceID();

		final String url = namespaceID == null ? null : namespaceID.getURL();

		return url == null ? "" : url.trim();

	}

	@Override
	public final String getLocalName()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		final String localName = elementID == null ? "" : elementID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

	@Override
	public final List<IODFAttribute> getAttributes() throws Exception
	{

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> map = this.getAttributeMap();

		final List<IODFAttribute> attributes = new ArrayList<>();

		if ((map == null ? 0 : map.size()) > 0)
		{

			final Set<ODF_ATTRIBUTE_ID> keySet = map.keySet();

			final Iterator<ODF_ATTRIBUTE_ID> iterator = keySet == null ? null : keySet.iterator();

			while (iterator == null ? false : iterator.hasNext())
			{

				final ODF_ATTRIBUTE_ID attributeID = iterator.next();

				final IODFAttributeValue value = map.get(attributeID);

				attributes.add(new ODFAttribute()
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

				});

			}

		}

		return Collections.unmodifiableList(attributes);

	}

	@Override
	public final IODFElementWriter getWriter()
	{

		return new ODFElementWriter()
		{

			@Override
			public final ODF_ELEMENT_ID getElementID()
			{

				return ODFElement.this.getElementID();

			}

			@Override
			public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
			{

				final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = ODFElement.this.getAttributeMap();

				return Collections.unmodifiableMap(attributes == null ? new Hashtable<>() : attributes);

			}

			@Override
			public final List<IODFNode> getNodes() throws Exception
			{

				final List<IODFNode> nodes = ODFElement.this.getNodes();

				return Collections.unmodifiableList(nodes == null ? new ArrayList<>() : nodes);

			}

		};

	}

}
