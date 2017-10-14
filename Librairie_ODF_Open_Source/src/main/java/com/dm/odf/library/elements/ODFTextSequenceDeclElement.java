package com.dm.odf.library.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFAttributeValue;
import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFElement;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFNode;
import com.dm.odf.library.interfaces.IODFTextSequenceDeclElement;

public abstract class ODFTextSequenceDeclElement extends ODFElement implements IODFTextSequenceDeclElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	private ODFTextSequenceDeclElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFAttributeValue getTextName();

	@Override
	public abstract IODFAttributeValue getDisplayOutlineLevel();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.TEXT_SEQUENCE_DECL;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
	{

		final IODFAttributeValue textName            = this.getTextName();
		final IODFAttributeValue displayOutlineLevel = this.getDisplayOutlineLevel();

		if (textName            == null) throw new Exception("Failed to retrieve text name value"            );
		if (displayOutlineLevel == null) throw new Exception("Failed to retrieve display outline level value");

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		attributes.put(ODF_ATTRIBUTE_ID.TEXT_DISPLAY_OUTLINE_LEVEL ,displayOutlineLevel);
		attributes.put(ODF_ATTRIBUTE_ID.TEXT_NAME                  ,textName           );

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes()
	{

		final List<IODFNode> nodes = new ArrayList<>();

		return Collections.unmodifiableList(nodes);

	}

	public static final IODFTextSequenceDeclElement newInstance(final int displayOutlineLevel,final String name)
	{

		if (displayOutlineLevel < 0) throw new IllegalArgumentException("Unexpected display outline level value [" + String.valueOf(displayOutlineLevel) + "]");

		return new ODFTextSequenceDeclElement()
		{

			@Override
			public final IODFAttributeValue getTextName()
			{

				return (name == null ? "" : name.trim()).length() == 0 ? null : ODFAttributeValue.newInstance(name.trim());

			}

			@Override
			public final IODFAttributeValue getDisplayOutlineLevel()
			{

				return ODFAttributeValue.newInstance(displayOutlineLevel);

			}

		};

	}

}
