package com.dm.odf.library.core;

import java.util.Iterator;
import java.util.List;

import com.dm.odf.library.interfaces.IODFAttribute;
import com.dm.odf.library.interfaces.IODFAttributes;

public abstract class ODFAttributes implements IODFAttributes
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFAttributes()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract List<IODFAttribute> getAttributes();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final Iterator<IODFAttribute> iterator()
	{

		final List<IODFAttribute> attributes = this.getAttributes();

		return attributes == null ? new ODFNullIterator<>() : attributes.iterator();

	}

}
