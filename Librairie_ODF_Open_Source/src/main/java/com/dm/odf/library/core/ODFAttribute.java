package com.dm.odf.library.core;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.nio.charset.Charset;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;
import com.dm.odf.library.interfaces.IODFAttribute;
import com.dm.odf.library.interfaces.IODFAttributeWriter;

public abstract class ODFAttribute implements IODFAttribute
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFAttribute()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_ATTRIBUTE_ID getAttributeID();

	@Override
	public abstract String getValue();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_NAMESPACE_ID getNamespaceID()
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		return attributeID == null ? null : attributeID.getNamespaceID();

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

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		final String localName = attributeID == null ? "" : attributeID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

	@Override
	public final IODFAttributeWriter getWriter()
	{

		return new ODFAttributeWriter()
		{

			@Override
			public final ODF_ATTRIBUTE_ID getAttributeID()
			{

				return ODFAttribute.this.getAttributeID();

			}

			@Override
			public final String getValue()
			{

				final String value = ODFAttribute.this.getValue();

				return value == null ? "" : value.trim();

			}

		};

	}

	@Override
	public final void write(final OutputStreamWriter writer) throws Exception
	{

		final IODFAttributeWriter attributeWriter = this.getWriter();

		if (attributeWriter == null) throw new Exception("Failed to retrieve ODF attribute writer instance");

		// S�rialisation

		if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

		try
		{

			attributeWriter.write(writer);

		}
		finally
		{

			writer.flush();

		}

	}

	@SuppressWarnings("resource")
	@Override
	public final String toString()
	{

		try
		{

			final Charset charset = Charset.defaultCharset();

			if (charset == null) throw new Exception("Failed to retrieve charset instance");

			final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

			try
			{

				final OutputStreamWriter writer = new OutputStreamWriter(outputStream,charset);

				try
				{

					this.write(writer);

				}
				finally
				{

					writer.flush();
					writer.close();

				}

			}
			finally
			{

				outputStream.close();

			}

			final byte[] data = outputStream.toByteArray();

			return (data == null ? 0 : data.length) == 0 ? "" : new String(data,charset);

		}
		catch (final Throwable exception)
		{

			exception.printStackTrace();

			return "";

		}

	}

}