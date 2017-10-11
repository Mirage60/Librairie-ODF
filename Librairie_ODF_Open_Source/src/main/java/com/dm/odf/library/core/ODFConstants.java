package com.dm.odf.library.core;

import javax.activation.MimeType;

import com.dm.odf.library.interfaces.IODFDocumentTypeID;

public final class ODFConstants
{

	public static enum ODF_DOCUMENT_TYPE_ID implements IODFDocumentTypeID
	{

		TEXT ("application/vnd.oasis.opendocument.text");

		private MimeType mimeType = null;

		@SuppressWarnings("hiding")
		ODF_DOCUMENT_TYPE_ID(final String mimeType)
		{

			try
			{

				this.mimeType = new MimeType(mimeType == null ? "" : mimeType.trim());

			}
			catch (final Throwable exception)
			{

				exception.printStackTrace();

			}

		}

		@Override
		public final MimeType getMimeType()
		{

			return this.mimeType;

		}

	}

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	private ODFConstants()
	{

		super();

	}

}
