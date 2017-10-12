package com.dm.odf.library.core;

import java.net.URL;

import javax.activation.MimeType;

import com.dm.odf.library.interfaces.IODFAttributeID;
import com.dm.odf.library.interfaces.IODFDocumentTypeID;
import com.dm.odf.library.interfaces.IODFElementID;
import com.dm.odf.library.interfaces.IODFNamespaceID;

public final class ODFConstants
{

	public static enum ODF_NAMESPACE_ID implements IODFNamespaceID
	{

		;

		private URL url = null;

		@SuppressWarnings("hiding")
		ODF_NAMESPACE_ID(final String url)
		{

			try
			{

				this.url = new URL(url == null ? "" : url.trim());

			}
			catch (final Throwable exception)
			{

				exception.printStackTrace();

			}

		}

		@Override
		public final URL getURL()
		{

			return this.url;

		}

	}

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

		BODY(null,"body");

		private ODF_NAMESPACE_ID namespaceID = null;
		private String localName = "";

		@SuppressWarnings("hiding")
		ODF_ELEMENT_ID(final ODF_NAMESPACE_ID namespaceID,final String localName)
		{

			this.namespaceID = namespaceID;
			this.localName   = localName == null ? "" : localName.trim();

		}

		@Override
		public final ODF_NAMESPACE_ID getNamespaceID()
		{

			return this.namespaceID;

		}

		@Override
		public final String getLocalName()
		{

			return this.localName;

		}

	}

	public static enum ODF_ATTRIBUTE_ID implements IODFAttributeID
	{

		NAME(null,"name");

		private ODF_NAMESPACE_ID namespaceID = null;
		private String localName = "";

		@SuppressWarnings("hiding")
		ODF_ATTRIBUTE_ID(final ODF_NAMESPACE_ID namespaceID,final String localName)
		{

			this.namespaceID = namespaceID;
			this.localName   = localName == null ? "" : localName.trim();

		}

		@Override
		public final ODF_NAMESPACE_ID getNamespaceID()
		{

			return this.namespaceID;

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
