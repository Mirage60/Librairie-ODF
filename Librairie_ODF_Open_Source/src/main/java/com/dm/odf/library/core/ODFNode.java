package com.dm.odf.library.core;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

import com.dm.odf.library.interfaces.IODFNode;
import com.dm.odf.library.interfaces.IODFWriter;

public abstract class ODFNode implements IODFNode
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFNode()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFWriter getWriter();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final void write(final OutputStreamWriter writer) throws Exception
	{

		final IODFWriter nodeWriter = this.getWriter();

		if (nodeWriter == null) throw new Exception("Failed to retrieve ODF node writer instance");

		// Sérialisation

		if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

		try
		{

			nodeWriter.write(writer);

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
