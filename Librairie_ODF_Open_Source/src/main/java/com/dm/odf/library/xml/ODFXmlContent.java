package com.dm.odf.library.xml;

import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import com.dm.odf.library.core.ODFTextContent;
import com.dm.odf.library.interfaces.IODFElement;
import com.dm.odf.library.interfaces.xml.IODFXmlContent;

public abstract class ODFXmlContent extends ODFTextContent implements IODFXmlContent
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFXmlContent()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFElement getRootElement();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	protected final void write(final OutputStreamWriter writer) throws Exception
	{

		final Charset charset = this.getCharset();

		if (charset == null) throw new Exception("Failed to retrieve charset instance");

		String encoding = charset.name();

		encoding = encoding == null ? "" : encoding.trim();

		if ("".equals(encoding)) throw new Exception("Undefined encoding");

		final IODFElement rootElement = this.getRootElement();

		if (rootElement == null) throw new Exception("Failed to retrieve XML root element instance");

		// Sérialisation

		if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

		try
		{

			writer.write("<?xml version=\"1.0\" encoding=\"" + encoding + "\"?>");

			rootElement.write(writer);

		}
		finally
		{

			writer.flush();

		}

	}

}
