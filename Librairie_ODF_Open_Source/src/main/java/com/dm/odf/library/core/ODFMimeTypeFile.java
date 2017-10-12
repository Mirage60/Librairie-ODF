package com.dm.odf.library.core;

import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.activation.MimeType;

import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFMimeTypeFile;

public abstract class ODFMimeTypeFile extends ODFPartFile implements IODFMimeTypeFile
{

	public static final String FILE_NAME = "mimetype";

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFMimeTypeFile()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final String getFileName()
	{

		return FILE_NAME.trim();

	}

	@Override
	public final IODFContent getContent()
	{

		return new ODFTextContent()
		{

			@Override
			public final MimeType getMimeType()
			{

				return null;

			}

			@Override
			public final Charset getCharset()
			{

				return StandardCharsets.UTF_8;

			}

			@Override
			protected final void write(final OutputStreamWriter writer) throws Exception
			{

				// Sérialisation

				if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

				try
				{

				}
				finally
				{

					writer.flush();

				}

			}

		};

	}

}
