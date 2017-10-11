package com.dm.odf.library.core;

import java.io.ByteArrayOutputStream;
import java.io.File;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFContentFile;
import com.dm.odf.library.interfaces.IODFDocument;
import com.dm.odf.library.interfaces.IODFMimeTypeFile;

public abstract class ODFDocument implements IODFDocument
{

	private final IODFContentFile contentFile = new ODFContentFile()
	{

		@Override
		public final IODFDocument getDocument()
		{

			return ODFDocument.this;

		}

	};

	private final IODFMimeTypeFile mimeTypeFile = new ODFMimeTypeFile()
	{

		@Override
		public final IODFDocument getDocument()
		{

			return ODFDocument.this;

		}

	};

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFDocument()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_DOCUMENT_TYPE_ID getDocumentTypeID();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final MimeType getMimeType()
	{

		final ODF_DOCUMENT_TYPE_ID mimeTypeID = this.getDocumentTypeID();

		return mimeTypeID == null ? null : mimeTypeID.getMimeType();

	}

	@Override
	public final IODFContentFile getContentFile()
	{

		return this.contentFile;

	}

	@Override
	public final IODFMimeTypeFile getMimeTypeFile()
	{

		return this.mimeTypeFile;

	}

	@Override
	public final IODFContent getContent()
	{

		return new ODFContent()
		{

			@Override
			public final MimeType getMimeType()
			{

				return ODFDocument.this.getMimeType();

			}

			@SuppressWarnings("resource")
			@Override
			public final byte[] getData() throws Exception
			{

				final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

				try
				{

				}
				finally
				{

					outputStream.flush();
					outputStream.close();

				}

				final byte[] data = outputStream.toByteArray();

				if ((data == null ? 0 : data.length) == 0) throw new Exception("Failed to retrieve document data");

				return data;

			}

		};

	}

	@Override
	public final void save(final File file) throws Exception
	{

		if (file == null) throw new IllegalArgumentException("Invalid file instance");

		final IODFContent content = this.getContent();

		if (content == null) throw new Exception("Failed to retrieve content instance");

		content.save(file);

	}

}
