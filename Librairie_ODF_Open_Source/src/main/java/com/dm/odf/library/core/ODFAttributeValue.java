package com.dm.odf.library.core;

import java.net.URL;

import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFKeywordProvider;

public abstract class ODFAttributeValue implements IODFAttributeValue
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFAttributeValue()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract String format();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final String toString()
	{

		final String text = this.format();

		return text == null ? "" : text.trim();

	}

	public static final IODFAttributeValue newInstance(final String value)
	{

		return new ODFAttributeValue()
		{

			@Override
			public final String format()
			{

				return value == null ? "" : value.trim();

			}

		};

	}

	public static final IODFAttributeValue newInstance(final ODF_NAMESPACE_ID value)
	{

		if (value == null) throw new IllegalArgumentException("Invalid namespace ID");

		final URL url = value.getURL();

		if (url == null) throw new IllegalArgumentException("Failed to retrieve URL for namespace ID [" + value.name() + "]");

		return new ODFAttributeValue()
		{

			@Override
			public final String format()
			{

				final String text = url.toString();

				return text == null ? "" : text.trim();

			}

		};

	}

	public static final IODFAttributeValue newInstance(final IODFKeywordProvider value)
	{

		if (value == null) throw new IllegalArgumentException("Invalid namespace ID");

		return new ODFAttributeValue()
		{

			@Override
			public final String format()
			{

				final String text = value.getKeyword();

				return text == null ? "" : text.trim();

			}

		};

	}

}
