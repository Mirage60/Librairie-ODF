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

	public static enum ODF_PART_FILE_ID
	{

		CONTENT,
		META,
		MIMETYPE,
		SETTINGS,
		STYLES;

	}

	public static enum ODF_NAMESPACE_ID implements IODFNamespaceID
	{

		OFFICE    ("office"    ,"urn:oasis:names:tc:opendocument:xmlns:office:1.0"                    ),
		STYLE     ("style"     ,"urn:oasis:names:tc:opendocument:xmlns:style:1.0"                     ),
		TEXT      ("text"      ,"urn:oasis:names:tc:opendocument:xmlns:text:1.0"                      ),
		TABLE     ("table"     ,"urn:oasis:names:tc:opendocument:xmlns:table:1.0"                     ),
		DRAW      ("draw"      ,"urn:oasis:names:tc:opendocument:xmlns:drawing:1.0"                   ),
		FO        ("fo"        ,"urn:oasis:names:tc:opendocument:xmlns:xsl-fo-compatible:1.0"         ),
		XLINK     ("xlink"     ,"http://www.w3.org/1999/xlink"                                        ),
		DC        ("dc"        ,"http://purl.org/dc/elements/1.1/"                                    ),
		META      ("meta"      ,"urn:oasis:names:tc:opendocument:xmlns:meta:1.0"                      ),
		NUMBER    ("number"    ,"urn:oasis:names:tc:opendocument:xmlns:datastyle:1.0"                 ),
		SVG       ("svg"       ,"urn:oasis:names:tc:opendocument:xmlns:svg-compatible:1.0"            ),
		CHART     ("chart"     ,"urn:oasis:names:tc:opendocument:xmlns:chart:1.0"                     ),
		DR3D      ("dr3d"      ,"urn:oasis:names:tc:opendocument:xmlns:dr3d:1.0"                      ),
		MATH      ("math"      ,"http://www.w3.org/1998/Math/MathML"                                  ),
		FORM      ("form"      ,"urn:oasis:names:tc:opendocument:xmlns:form:1.0"                      ),
		SCRIPT    ("script"    ,"urn:oasis:names:tc:opendocument:xmlns:script:1.0"                    ),
		OOO       ("ooo"       ,"http://openoffice.org/2004/office"                                   ),
		OOOW      ("ooow"      ,"http://openoffice.org/2004/writer"                                   ),
		OOOC      ("oooc"      ,"http://openoffice.org/2004/calc"                                     ),
		DOM       ("dom"       ,"http://www.w3.org/2001/xml-events"                                   ),
		XFORMS    ("xforms"    ,"http://www.w3.org/2002/xforms"                                       ),
		XSD       ("xsd"       ,"http://www.w3.org/2001/XMLSchema"                                    ),
		XSI       ("xsi"       ,"http://www.w3.org/2001/XMLSchema-instance"                           ),
		RPT       ("rpt"       ,"http://openoffice.org/2005/report"                                   ),
		OF        ("of"        ,"urn:oasis:names:tc:opendocument:xmlns:of:1.2"                        ),
		XHTML     ("xhtml"     ,"http://www.w3.org/1999/xhtml"                                        ),
		GRDDL     ("grddl"     ,"http://www.w3.org/2003/g/data-view#"                                 ),
		OFFICEOOO ("officeooo" ,"http://openoffice.org/2009/office"                                   ),
		TABLEOOO  ("tableooo"  ,"http://openoffice.org/2009/table"                                    ),
		DRAWOOO   ("drawooo"   ,"http://openoffice.org/2010/draw"                                     ),
		CALCEXT   ("calcext"   ,"urn:org:documentfoundation:names:experimental:calc:xmlns:calcext:1.0"),
		LOEXT     ("loext"     ,"urn:org:documentfoundation:names:experimental:office:xmlns:loext:1.0"),
		FIELD     ("field"     ,"urn:openoffice:names:experimental:ooo-ms-interop:xmlns:field:1.0"    ),
		FORMX     ("formx"     ,"urn:openoffice:names:experimental:ooxml-odf-interop:xmlns:form:1.0"  ),
		CSS3T     ("css3t"     ,"http://www.w3.org/TR/css3-text/"                                     );

		private String prefix = "";
		private URL url = null;

		@SuppressWarnings("hiding")
		ODF_NAMESPACE_ID(final String prefix,final String url)
		{

			try
			{

				this.prefix = prefix == null ? "" : prefix.trim();
				this.url    = new URL(url == null ? "" : url.trim());

			}
			catch (final Throwable exception)
			{

				exception.printStackTrace();

			}

		}

		@Override
		public final String getPrefix()
		{

			return this.prefix;

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
