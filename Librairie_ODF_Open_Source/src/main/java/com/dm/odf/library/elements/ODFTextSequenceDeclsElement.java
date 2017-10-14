package com.dm.odf.library.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFElement;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFNode;
import com.dm.odf.library.interfaces.IODFTextSequenceDeclElement;
import com.dm.odf.library.interfaces.IODFTextSequenceDeclsElement;

public abstract class ODFTextSequenceDeclsElement extends ODFElement implements IODFTextSequenceDeclsElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFTextSequenceDeclsElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract List<IODFTextSequenceDeclElement> getElements();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.TEXT_SEQUENCE_DECLS;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
	{

		return Collections.unmodifiableMap(new Hashtable<>());

	}

	@Override
	public final List<IODFNode> getNodes()
	{

		final List<IODFTextSequenceDeclElement> elements = this.getElements();

		final List<IODFNode> nodes = new ArrayList<>();

		if ((elements == null ? 0 : elements.size()) > 0)
		{

			nodes.addAll(elements);

		}

		return Collections.unmodifiableList(nodes);

	}

}
