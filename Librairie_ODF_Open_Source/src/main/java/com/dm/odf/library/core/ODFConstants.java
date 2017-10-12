package com.dm.odf.library.core;

import java.net.URL;

import javax.activation.MimeType;

import com.dm.odf.library.interfaces.IODFAttributeID;
import com.dm.odf.library.interfaces.IODFDocumentTypeID;
import com.dm.odf.library.interfaces.IODFElementID;
import com.dm.odf.library.interfaces.IODFMimeTypeID;
import com.dm.odf.library.interfaces.IODFNamespaceID;

public final class ODFConstants
{

	public static final int KO = 1024;
	public static final int MO = KO * 1000;
	public static final int GO = MO * 1000;

	public static final String VERSION       = "1.0";
	public static final String NOT_AVAILABLE = "N/A";

	public static final int BUFFER_SIZE = 2048;

	public static final int MIN_PORT_NUMBER = 0;
	public static final int MAX_PORT_NUMBER = 65535;

	public static final int MAX_FAVICON_SIZE = 192;

	public static final float MIN_WIDTH_RATIO = 0.0f;
	public static final float MAX_WIDTH_RATIO = 1.0f;

	public static final String EOL = SYSTEM_PROPERTY_ID.LINE_SEPARATOR.getValue();

    public static enum SYSTEM_PROPERTY_ID
    {

	    USER_NAME        ("user.name"      ),
		USER_HOME        ("user.home"      ),
		TEMP_DIRECTORY   ("java.io.tmpdir" ),
		LINE_SEPARATOR   ("line.separator" ),
		CLASS_PATH       ("java.class.path"),
		OPERATING_SYSTEM ("os.name"        );

		private String name = "";

		@SuppressWarnings("hiding")
		SYSTEM_PROPERTY_ID(final String name)
		{

		    this.name= name == null ? "" : name.trim();

		}

		public final String getValue()
		{

		    final String value = "".equals(this.name) ? "" : System.getProperty(this.name);

		    return value == null ? "" : LINE_SEPARATOR.equals(this) ? value : value.trim();

		}

    }

	public static enum ODF_MIME_TYPE_ID implements IODFMimeTypeID
	{

		TEXT          ("text/plain"),
		XML           ("text/xml"  ),
		TEXT_DOCUMENT (""          );

		private MimeType mimeType = null;

		@SuppressWarnings("hiding")
		ODF_MIME_TYPE_ID(final String mimeType)
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

		TEXT (ODF_MIME_TYPE_ID.TEXT);

		private ODF_MIME_TYPE_ID mimeTypeID = null;

		@SuppressWarnings("hiding")
		ODF_DOCUMENT_TYPE_ID(final ODF_MIME_TYPE_ID mimeTypeID)
		{

			this.mimeTypeID = mimeTypeID;

		}

		@Override
		public final ODF_MIME_TYPE_ID getMimeTypeID()
		{

			return this.mimeTypeID;

		}

		@Override
		public final MimeType getMimeType()
		{

			return this.mimeTypeID == null ? null : this.mimeTypeID.getMimeType();

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
