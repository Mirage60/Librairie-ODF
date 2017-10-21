package com.dm.odf.library.core;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;
import com.dm.odf.library.interfaces.IODFAttribute;
import com.dm.odf.library.interfaces.IODFAttributeValue;
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
	public abstract IODFAttributeValue getValue();

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
	public final String getNamespaceURL()
	{

		final ODF_NAMESPACE_ID namespaceID = this.getNamespaceID();

		final String url = namespaceID == null ? null : namespaceID.getURL();

		return url == null ? "" : url.trim();

	}

	@Override
	public final String getPrefix()
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		final String prefix = attributeID == null ? null : attributeID.getPrefix();

		return prefix == null ? "" : prefix.trim();

	}

	@Override
	public final String getLocalName()
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		final String localName = attributeID == null ? "" : attributeID.getLocalName();

		return localName == null ? "" : localName.trim();

	}

	@Override
	public final String getAttributeName()
	{

		final ODF_ATTRIBUTE_ID attributeID = this.getAttributeID();

		final String name = attributeID == null ? null : attributeID.getAttributeName();

		return name == null ? "" : name.trim();

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
			public final IODFAttributeValue getValue()
			{

				return ODFAttribute.this.getValue();

			}

		};

	}

	@Override
	public final void write(final OutputStreamWriter writer) throws Exception
	{

		final IODFAttributeWriter attributeWriter = this.getWriter();

		if (attributeWriter == null) throw new Exception("Failed to retrieve ODF attribute writer instance");

		// Sérialisation

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

			ODFLogger.log(exception);

			return "";

		}

	}

}
