package com.dm.odf.library.core;

import javax.activation.MimeType;

import com.dm.odf.library.interfaces.IODFAttributeID;
import com.dm.odf.library.interfaces.IODFDocumentTypeID;
import com.dm.odf.library.interfaces.IODFElementID;

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

	public static enum ODF_ELEMENT_ID implements IODFElementID
	{

		BODY("body");

		private String localName = "";

		@SuppressWarnings("hiding")
		ODF_ELEMENT_ID(final String localName)
		{

			this.localName = localName == null ? "" : localName.trim();

		}

		@Override
		public final String getLocalName()
		{

			return this.localName;

		}

	}

	public static enum ODF_ATTRIBUTE_ID implements IODFAttributeID
	{

		NAME("name");

		private String localName = "";

		@SuppressWarnings("hiding")
		ODF_ATTRIBUTE_ID(final String localName)
		{

			this.localName = localName == null ? "" : localName.trim();

		}

		@Override
		public final String getLocalName()
		{

			return this.localName;

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
