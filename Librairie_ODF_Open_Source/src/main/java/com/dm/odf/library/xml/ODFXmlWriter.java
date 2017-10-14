package com.dm.odf.library.xml;

import com.dm.odf.library.core.ODFWriter;
import com.dm.odf.library.interfaces.IODFXmlWriter;

public abstract class ODFXmlWriter extends ODFWriter implements IODFXmlWriter
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFXmlWriter()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	public static final String getHexaEntity(final char character)
	{

	    final String value = Integer.toHexString(character);

	    return "&#x" + value.toUpperCase() + ";";

	}

	public static final String getDecimalEntity(final char character)
	{

	    return "&#" + String.valueOf((int) character) + ";";

	}

	public static final String getEntity(final char character)
	{

		final String decimal = getDecimalEntity (character);
		final String hexa    = getHexaEntity    (character);

		switch (hexa.compareTo(decimal))
		{
		case -1 : return hexa;
		case 0  : return hexa;
		default : return decimal;
		}

	}

	public static final String strToXml(final String text)
	{

		final char[] buffer = text == null ? null : text.toCharArray();

		final int length = buffer == null ? 0 : buffer.length;

		if (length == 0) return "";

		final StringBuilder builder = new StringBuilder();

		for (final char character : buffer)
		{

			switch (character)
			{
			case '<'  : { builder.append(getEntity(character)); break; }
			case '>'  : { builder.append(getEntity(character)); break; }
			case '&'  : { builder.append(getEntity(character)); break; }
			case '"'  : { builder.append(getEntity(character)); break; }
			case '\'' : { builder.append(getEntity(character)); break; }
			default   : { builder.append(character <= 127 ? "" + character : getEntity(character)); break; }
			}

		}

		return builder.toString();

	}

}
