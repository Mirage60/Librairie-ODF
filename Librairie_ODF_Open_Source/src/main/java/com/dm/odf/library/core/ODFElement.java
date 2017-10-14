package com.dm.odf.library.core;

import java.net.URL;
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
	public abstract Map<ODF_ATTRIBUTE_ID,String> getAttributeMap();

	@Override
	public abstract List<IODFNode> getNodes();

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
	public final String getName()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		final String name = elementID == null ? null : elementID.getName();

		return name == null ? "" : name.trim();

	}

	@Override
	public final URL getNamespaceURL()
	{

		final ODF_NAMESPACE_ID namespaceID = this.getNamespaceID();

		return namespaceID == null ? null : namespaceID.getURL();

	}

	@Override
	public final String getLocalName()
	{

		final ODF_ELEMENT_ID elementID = this.getElementID();

		final String localName = elementID == null ? "" : elementID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

	@Override
	public final List<IODFAttribute> getAttributes()
	{

		final Map<ODF_ATTRIBUTE_ID,String> map = this.getAttributeMap();

		final List<IODFAttribute> attributes = new ArrayList<>();

		if ((map == null ? 0 : map.size()) > 0)
		{

			final Set<ODF_ATTRIBUTE_ID> keySet = map.keySet();

			final Iterator<ODF_ATTRIBUTE_ID> iterator = keySet == null ? null : keySet.iterator();

			while (iterator == null ? false : iterator.hasNext())
			{

				final ODF_ATTRIBUTE_ID attributeID = iterator.next();

				final String value = map.get(attributeID);

				attributes.add(new ODFAttribute()
				{

					@Override
					public final ODF_ATTRIBUTE_ID getAttributeID()
					{

						return attributeID;

					}

					@Override
					public final String getValue()
					{

						return value == null ? "" : value.trim();

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
			public final Map<ODF_ATTRIBUTE_ID,String> getAttributeMap()
			{

				final Map<ODF_ATTRIBUTE_ID,String> attributes = ODFElement.this.getAttributeMap();

				return Collections.unmodifiableMap(attributes == null ? new Hashtable<>() : attributes);

			}

			@Override
			public final List<IODFNode> getNodes()
			{

				final List<IODFNode> nodes = ODFElement.this.getNodes();

				return Collections.unmodifiableList(nodes == null ? new ArrayList<>() : nodes);

			}

		};

	}

}
