package com.dm.odf.library.core;

import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFDocument;
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
			public final ODF_MIME_TYPE_ID getMimeTypeID()
			{

				return ODF_MIME_TYPE_ID.TEXT;

			}

			@Override
			public final Charset getCharset()
			{

				return StandardCharsets.UTF_8;

			}

			@Override
			protected final void write(final OutputStreamWriter writer) throws Exception
			{

				final IODFDocument document = ODFMimeTypeFile.this.getDocument();

				if (document == null) throw new Exception("Failed to retrieve ODF document instance");

				final MimeType mimeType = document.getMimeType();

				if (mimeType == null) throw new Exception("Failed to retrieve mime type instance");

				String baseType = mimeType.getBaseType();

				baseType = baseType == null ? "" : baseType.trim();

				if ("".equals(baseType)) throw new Exception("Undefined mime type");

				// Sérialisation

				if (writer == null) throw new IllegalArgumentException("Invalid writer instance");

				try
				{

					writer.write(baseType + ODFConstants.EOL);

				}
				finally
				{

					writer.flush();

				}

			}

		};

	}

}
