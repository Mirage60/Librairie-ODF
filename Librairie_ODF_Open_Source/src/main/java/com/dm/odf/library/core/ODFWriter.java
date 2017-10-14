package com.dm.odf.library.core;

import java.io.OutputStreamWriter;

import com.dm.odf.library.interfaces.IODFWriter;

public abstract class ODFWriter implements IODFWriter
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFWriter()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract void write(final OutputStreamWriter writer) throws Exception;

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
