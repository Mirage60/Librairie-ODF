package com.dm.odf.library.core;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.zip.ZipOutputStream;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFContentFile;
import com.dm.odf.library.interfaces.IODFDocument;
import com.dm.odf.library.interfaces.IODFMetaFile;
import com.dm.odf.library.interfaces.IODFMimeTypeFile;
import com.dm.odf.library.interfaces.IODFSettingsFile;
import com.dm.odf.library.interfaces.IODFStylesFile;

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

	private final IODFStylesFile stylesFile = new ODFStylesFile()
	{

		@Override
		public final IODFDocument getDocument()
		{

			return ODFDocument.this;

		}

	};

	private final IODFMetaFile metaFile = new ODFMetaFile()
	{

		@Override
		public final IODFDocument getDocument()
		{

			return ODFDocument.this;

		}

	};

	private final IODFSettingsFile settingsFile = new ODFSettingsFile()
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
	public final ODF_MIME_TYPE_ID getMimeTypeID()
	{

		final ODF_DOCUMENT_TYPE_ID mimeTypeID = this.getDocumentTypeID();

		return mimeTypeID == null ? null : mimeTypeID.getMimeTypeID();

	}

	@Override
	public final MimeType getMimeType()
	{

		final ODF_MIME_TYPE_ID mimeTypeID = this.getMimeTypeID();

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
	public final IODFStylesFile getStylesFile()
	{

		return this.stylesFile;

	}

	@Override
	public final IODFMetaFile getMetaFile()
	{

		return this.metaFile;

	}

	@Override
	public final IODFSettingsFile getSettingsFile()
	{

		return this.settingsFile;

	}

	@Override
	public final IODFContent getContent()
	{

		return new ODFContent()
		{

			@Override
			public final ODF_MIME_TYPE_ID getMimeTypeID()
			{

				return ODFDocument.this.getMimeTypeID();

			}

			@SuppressWarnings("resource")
			@Override
			public final byte[] getData() throws Exception
			{

				final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

				try
				{

					final ZipOutputStream archiveStream = new ZipOutputStream(outputStream);

					try
					{

					}
					finally
					{

						archiveStream.flush();
						archiveStream.close();

					}

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
