package com.dm.odf.library.core;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import com.dm.odf.library.interfaces.IODFTextContent;

public abstract class ODFTextContent extends ODFContent implements IODFTextContent
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFTextContent()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	protected abstract void write(final OutputStreamWriter writer) throws Exception;

	@Override
	public abstract Charset getCharset();

	//==========================================================================
	// METHODES
	//==========================================================================

	@SuppressWarnings("resource")
	@Override
	public final byte[] getData() throws Exception
	{

		final Charset charset = this.getCharset();

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

		if ((data == null ? 0 : data.length) == 0) throw new Exception("Failed to retrieve document data");

		return data;

	}

	@Override
	public final String toString()
	{

		try
		{

			final Charset charset = this.getCharset();

			if (charset == null) throw new Exception("Failed to retrieve charset instance");

			final byte[] data = this.getData();

			return (data == null ? 0 : data.length) == 0 ? "" : new String(data,charset);

		}
		catch (final Throwable exception)
		{

			ODFLogger.log(exception);

			return "";

		}

	}

}
