package com.dm.odf.library.core;

import javax.activation.MimeType;

import com.dm.odf.library.interfaces.IODFAttribute;
import com.dm.odf.library.interfaces.IODFAttributeID;
import com.dm.odf.library.interfaces.IODFAttributeValue;
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

		TEXT          ("text/plain"                             ),
		XML           ("text/xml"                               ),
		TEXT_DOCUMENT ("application/vnd.oasis.opendocument.text");

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
		private String url = "";

		@SuppressWarnings("hiding")
		ODF_NAMESPACE_ID(final String prefix,final String url)
		{

			try
			{

				this.prefix = prefix == null ? "" : prefix .trim();
				this.url    = url    == null ? "" : url    .trim();

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
		public final String getURL()
		{

			return this.url;

		}

		public static final ODF_NAMESPACE_ID findByPrefix(final String prefix)
		{

			final String key = prefix == null ? "" : prefix.trim();

			if ("".equals(key)) return null;

			for (final ODF_NAMESPACE_ID enumValue : ODF_NAMESPACE_ID.values())
			{

				assert enumValue != null : "Unexpected null enum value";

				if (key.equals(enumValue.getPrefix())) return enumValue;

			}

			return null;

		}

		public static final ODF_NAMESPACE_ID findByURL(final String url)
		{

			final String key = url == null ? "" : url.trim();

			if ("".equals(url)) return null;

			for (final ODF_NAMESPACE_ID enumValue : ODF_NAMESPACE_ID.values())
			{

				assert enumValue != null : "Unexpected null enum value";

				if (key.equalsIgnoreCase(enumValue.getURL())) return enumValue;

			}

			return null;

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

		OFFICE_DOCUMENT_CONTENT         (ODF_NAMESPACE_ID.OFFICE ,"document-content"           ),
		OFFICE_SCRIPTS                  (ODF_NAMESPACE_ID.OFFICE ,"scripts"                    ),
		OFFICE_FONT_FACE_DECLS          (ODF_NAMESPACE_ID.OFFICE ,"font-face-decls"            ),
		OFFICE_AUTOMATIC_STYLES         (ODF_NAMESPACE_ID.OFFICE ,"automatic-styles"           ),
		OFFICE_BODY                     (ODF_NAMESPACE_ID.OFFICE ,"body"                       ),
		OFFICE_TEXT                     (ODF_NAMESPACE_ID.OFFICE ,"text"                       ),
		OFFICE_STYLES                   (ODF_NAMESPACE_ID.OFFICE ,"styles"                     ),
		OFFICE_MASTER_STYLES            (ODF_NAMESPACE_ID.OFFICE ,"master-styles"              ),
		STYLE_FONT_FACE                 (ODF_NAMESPACE_ID.STYLE  ,"font-face"                  ),
		STYLE_DEFAULT_STYLE             (ODF_NAMESPACE_ID.STYLE  ,"default-style"              ),
		STYLE_STYLE                     (ODF_NAMESPACE_ID.STYLE  ,"style"                      ),
		STYLE_MASTER_PAGE               (ODF_NAMESPACE_ID.STYLE  ,"master-page"                ),
		STYLE_PAGE_LAYOUT               (ODF_NAMESPACE_ID.STYLE  ,"page-layout"                ),
		STYLE_PAGE_LAYOUT_PROPERTIES    (ODF_NAMESPACE_ID.STYLE  ,"page-layout-properties"     ),
		STYLE_TAB_STOPS                 (ODF_NAMESPACE_ID.STYLE  ,"tab-stops"                  ),
		STYLE_GRAPHIC_PROPERTIES        (ODF_NAMESPACE_ID.STYLE  ,"graphic-properties"         ),
		STYLE_PARAGRAPH_PROPERTIES      (ODF_NAMESPACE_ID.STYLE  ,"paragraph-properties"       ),
		STYLE_LIST_LEVEL_PROPERTIES     (ODF_NAMESPACE_ID.STYLE  ,"list-level-properties"      ),
		STYLE_TEXT_PROPERTIES           (ODF_NAMESPACE_ID.STYLE  ,"text-properties"            ),
		STYLE_TABLE_PROPERTIES          (ODF_NAMESPACE_ID.STYLE  ,"table-properties"           ),
		STYLE_FOOTNOTE_SEP              (ODF_NAMESPACE_ID.STYLE  ,"footnote-sep"               ),
		STYLE_HEADER_STYLE              (ODF_NAMESPACE_ID.STYLE  ,"header-style"               ),
		STYLE_FOOTER_STYLE              (ODF_NAMESPACE_ID.STYLE  ,"footer-style"               ),
		TEXT_SEQUENCE_DECLS             (ODF_NAMESPACE_ID.TEXT   ,"sequence-decls"             ),
		TEXT_SEQUENCE_DECL              (ODF_NAMESPACE_ID.TEXT   ,"sequence-decl"              ),
		TEXT_OUTLINE_STYLE              (ODF_NAMESPACE_ID.TEXT   ,"outline-style"              ),
		TEXT_NOTES_CONFIGURATION        (ODF_NAMESPACE_ID.TEXT   ,"notes-configuration"        ),
		TEXT_LINENUMBERING_CONGIRUATION (ODF_NAMESPACE_ID.TEXT   ,"linenumbering-configuration"),
		TEXT_OUTLINE_LEVEL_STYLE        (ODF_NAMESPACE_ID.TEXT   ,"outline-level-style"        ),
		TEXT_P                          (ODF_NAMESPACE_ID.TEXT   ,"p"                          );

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
		public final String getPrefix()
		{

			final String prefix = this.namespaceID == null ? "" : this.namespaceID.getPrefix();

			return prefix == null ? "" : prefix.trim();

		}

		@Override
		public final String getLocalName()
		{

			return this.localName;

		}

		@Override
		public final String getName()
		{

			final String prefix = this.getPrefix();

			return ("".equals(prefix) ? "" : prefix + ":") + this.localName;

		}

	}

	public static enum ODF_ATTRIBUTE_ID implements IODFAttributeID
	{

		// Espaces de noms

		XMLNS_OFFICE    (ODF_NAMESPACE_ID.OFFICE   ),
		XMLNS_STYLE     (ODF_NAMESPACE_ID.STYLE    ),
		XMLNS_TEXT      (ODF_NAMESPACE_ID.TEXT     ),
		XMLNS_TABLE     (ODF_NAMESPACE_ID.TABLE    ),
		XMLNS_DRAW      (ODF_NAMESPACE_ID.DRAW     ),
		XMLNS_FO        (ODF_NAMESPACE_ID.FO       ),
		XMLNS_XLINK     (ODF_NAMESPACE_ID.XLINK    ),
		XMLNS_DC        (ODF_NAMESPACE_ID.DC       ),
		XMLNS_META      (ODF_NAMESPACE_ID.META     ),
		XMLNS_NUMBER    (ODF_NAMESPACE_ID.NUMBER   ),
		XMLNS_SVG       (ODF_NAMESPACE_ID.SVG      ),
		XMLNS_CHART     (ODF_NAMESPACE_ID.CHART    ),
		XMLNS_DR3D      (ODF_NAMESPACE_ID.DR3D     ),
		XMLNS_MATH      (ODF_NAMESPACE_ID.MATH     ),
		XMLNS_FORM      (ODF_NAMESPACE_ID.FORM     ),
		XMLNS_SCRIPT    (ODF_NAMESPACE_ID.SCRIPT   ),
		XMLNS_OOO       (ODF_NAMESPACE_ID.OOO      ),
		XMLNS_OOOW      (ODF_NAMESPACE_ID.OOOW     ),
		XMLNS_OOOC      (ODF_NAMESPACE_ID.OOOC     ),
		XMLNS_DOM       (ODF_NAMESPACE_ID.DOM      ),
		XMLNS_XFORMS    (ODF_NAMESPACE_ID.XFORMS   ),
		XMLNS_XSD       (ODF_NAMESPACE_ID.XSD      ),
		XMLNS_XSI       (ODF_NAMESPACE_ID.XSI      ),
		XMLNS_RPT       (ODF_NAMESPACE_ID.RPT      ),
		XMLNS_OF        (ODF_NAMESPACE_ID.OF       ),
		XMLNS_XHTML     (ODF_NAMESPACE_ID.XHTML    ),
		XMLNS_GRDDL     (ODF_NAMESPACE_ID.GRDDL    ),
		XMLNS_OFFICEOOO (ODF_NAMESPACE_ID.OFFICEOOO),
		XMLNS_TABLEOOO  (ODF_NAMESPACE_ID.TABLEOOO ),
		XMLNS_DRAWOOO   (ODF_NAMESPACE_ID.DRAWOOO  ),
		XMLNS_CALCEXT   (ODF_NAMESPACE_ID.CALCEXT  ),
		XMLNS_LOEXT     (ODF_NAMESPACE_ID.LOEXT    ),
		XMLNS_FIELD     (ODF_NAMESPACE_ID.FIELD    ),
		XMLNS_FORMX     (ODF_NAMESPACE_ID.FORMX    ),
		XMLNS_CSS3T     (ODF_NAMESPACE_ID.CSS3T    ),

		// Attributs

		OFFICE_VERSION                      (ODF_NAMESPACE_ID.OFFICE ,"version"                      ),
		STYLE_NAME                          (ODF_NAMESPACE_ID.STYLE  ,"name"                         ),
		STYLE_DISPLAY_NAME                  (ODF_NAMESPACE_ID.STYLE  ,"display-name"                 ),
		STYLE_PAGE_LAYOUT_NAME              (ODF_NAMESPACE_ID.STYLE  ,"page-layout-name"             ),
		STYLE_FAMILY                        (ODF_NAMESPACE_ID.STYLE  ,"family"                       ),
		STYLE_CLASS                         (ODF_NAMESPACE_ID.STYLE  ,"class"                        ),
		STYLE_PARENT_STYLE_NAME             (ODF_NAMESPACE_ID.STYLE  ,"parent-style-name"            ),
		STYLE_WIDTH                         (ODF_NAMESPACE_ID.STYLE  ,"width"                        ),
		STYLE_HEIGHT                        (ODF_NAMESPACE_ID.STYLE  ,"height"                       ),
		STYLE_DISTANCE_BEFORE_SEP           (ODF_NAMESPACE_ID.STYLE  ,"distance-before-sep"          ),
		STYLE_DISTANCE_AFTER_SEP            (ODF_NAMESPACE_ID.STYLE  ,"distance-after-sep"           ),
		STYLE_FONT_NAME                     (ODF_NAMESPACE_ID.STYLE  ,"font-name"                    ),
		STYLE_FONT_NAME_ASIAN               (ODF_NAMESPACE_ID.STYLE  ,"font-name-asian"              ),
		STYLE_FONT_NAME_COMPLEX             (ODF_NAMESPACE_ID.STYLE  ,"font-name-complex"            ),
		STYLE_FONT_COMPLEX                  (ODF_NAMESPACE_ID.STYLE  ,"font-name-complex"            ),
		STYLE_FONT_FAMILY_ASIAN             (ODF_NAMESPACE_ID.STYLE  ,"font-family-asian"            ),
		STYLE_FONT_FAMILY_COMPLEX           (ODF_NAMESPACE_ID.STYLE  ,"font-family-complex"          ),
		STYLE_FONT_FAMILY_GENERIC           (ODF_NAMESPACE_ID.STYLE  ,"font-family-generic"          ),
		STYLE_FONT_FAMILY_GENERIC_ASIAN     (ODF_NAMESPACE_ID.STYLE  ,"font-family-generic-asian"    ),
		STYLE_FONT_FAMILY_GENERIC_COMPLEX   (ODF_NAMESPACE_ID.STYLE  ,"font-family-generic-complex"  ),
		STYLE_FONT_SIZE                     (ODF_NAMESPACE_ID.STYLE  ,"font-size"                    ),
		STYLE_FONT_SIZE_ASIAN               (ODF_NAMESPACE_ID.STYLE  ,"font-size-asian"              ),
		STYLE_FONT_SIZE_COMPLEX             (ODF_NAMESPACE_ID.STYLE  ,"font-size-complex"            ),
		STYLE_FONT_PITCH                    (ODF_NAMESPACE_ID.STYLE  ,"font-pitch"                   ),
		STYLE_FONT_PITCH_ASIAN              (ODF_NAMESPACE_ID.STYLE  ,"font-pitch-asian"             ),
		STYLE_FONT_PITCH_COMPLEX            (ODF_NAMESPACE_ID.STYLE  ,"font-pitch-complex"           ),
		STYLE_NEXT_STYLE_NAME               (ODF_NAMESPACE_ID.STYLE  ,"next-style-name"              ),
		STYLE_FLOW_WITH_TEXT                (ODF_NAMESPACE_ID.STYLE  ,"flow-with-text"               ),
		STYLE_TEXT_AUTOSPACE                (ODF_NAMESPACE_ID.STYLE  ,"text-autospace"               ),
		STYLE_LINE_BREAK                    (ODF_NAMESPACE_ID.STYLE  ,"line-break"                   ),
		STYLE_WRITING_MODE                  (ODF_NAMESPACE_ID.STYLE  ,"writing-mode"                 ),
		STYLE_USE_WINDOW_FONT_COLOR         (ODF_NAMESPACE_ID.STYLE  ,"use-window-font-color"        ),
		STYLE_FONT_INDEPENDENT_LINE_SPACING (ODF_NAMESPACE_ID.STYLE  ,"font-independent-line-spacing"),
		STYLE_LETTER_KERNING                (ODF_NAMESPACE_ID.STYLE  ,"letter-kerning"               ),
		STYLE_LANGUAGE_ASIAN                (ODF_NAMESPACE_ID.STYLE  ,"language"                     ),
		STYLE_LANGUAGE_COMPLEX              (ODF_NAMESPACE_ID.STYLE  ,"language-complex"             ),
		STYLE_COUNTRY_ASIAN                 (ODF_NAMESPACE_ID.STYLE  ,"country"                      ),
		STYLE_COUNTRY_COMPLEX               (ODF_NAMESPACE_ID.STYLE  ,"country-complex"              ),
		STYLE_PUNCTUATION_WRAP              (ODF_NAMESPACE_ID.STYLE  ,"punctuation-wrap"             ),
		STYLE_TAB_STOP_DISTANCE             (ODF_NAMESPACE_ID.STYLE  ,"tab-stop-distance"            ),
		STYLE_NUM_FORMAT                    (ODF_NAMESPACE_ID.STYLE  ,"num-format"                   ),
		STYLE_PRINT_ORIENTATION             (ODF_NAMESPACE_ID.STYLE  ,"print-orientation"            ),
		STYLE_FOOTNOTE_MAX_HEIGHT           (ODF_NAMESPACE_ID.STYLE  ,"footnote-max-height"          ),
		STYLE_LINE_STYLE                    (ODF_NAMESPACE_ID.STYLE  ,"line-style"                   ),
		STYLE_ADJUSTMENT                    (ODF_NAMESPACE_ID.STYLE  ,"adjustment"                   ),
		STYLE_REL_WIDTH                     (ODF_NAMESPACE_ID.STYLE  ,"rel-width"                    ),
		STYLE_COLOR                         (ODF_NAMESPACE_ID.STYLE  ,"color"                        ),
		SVG_FONT_FAMILY                     (ODF_NAMESPACE_ID.SVG    ,"font-family"                  ),
		SVG_STROKE_COLOR                    (ODF_NAMESPACE_ID.SVG    ,"stroke-color"                 ),
		TEXT_STYLE_NAME                     (ODF_NAMESPACE_ID.TEXT   ,"style-name"                   ),
		TEXT_NAME                           (ODF_NAMESPACE_ID.TEXT   ,"name"                         ),
		TEXT_DISPLAY_OUTLINE_LEVEL          (ODF_NAMESPACE_ID.TEXT   ,"display-outline-level"        ),
		TEXT_NUMBER_LINE                    (ODF_NAMESPACE_ID.TEXT   ,"number-line"                  ),
		TEXT_LINE_NUMBER                    (ODF_NAMESPACE_ID.TEXT   ,"line-number"                  ),
		DRAW_FILLE_COLOR                    (ODF_NAMESPACE_ID.DRAW   ,"fill-color"                   ),
		DRAW_SHADOW_OFFSET_X                (ODF_NAMESPACE_ID.DRAW   ,"shadow-offset-x"              ),
		DRAW_SHADOW_OFFSET_Y                (ODF_NAMESPACE_ID.DRAW   ,"shadow-offset-y"              ),
		DRAW_START_LINE_SPACING_HORIZONTAL  (ODF_NAMESPACE_ID.DRAW   ,"start-line-spacing-horizontal"),
		DRAW_START_LINE_SPACING_VERTICAL    (ODF_NAMESPACE_ID.DRAW   ,"start-line-spacing-vertical"  ),
		DRAW_END_LINE_SPACING_HORIZONTAL    (ODF_NAMESPACE_ID.DRAW   ,"end-line-spacing-horizontal"  ),
		DRAW_END_LINE_SPACING_VERTICAL      (ODF_NAMESPACE_ID.DRAW   ,"end-line-spacing-vertical"    ),
		TABLE_BORDER_MODEL                  (ODF_NAMESPACE_ID.TABLE  ,"border-model"                 ),
		FO_PAGE_WIDTH                       (ODF_NAMESPACE_ID.FO     ,"page-width"                   ),
		FO_PAGE_HEIGHT                      (ODF_NAMESPACE_ID.FO     ,"page-height"                  ),
		FO_FONT_FAMILY                      (ODF_NAMESPACE_ID.FO     ,"font-family"                  ),
		FO_FONT_SIZE                        (ODF_NAMESPACE_ID.FO     ,"font-size"                    ),
		FO_MARGIN_LEFT                      (ODF_NAMESPACE_ID.FO     ,"margin-left"                  ),
		FO_MARGIN_TOP                       (ODF_NAMESPACE_ID.FO     ,"margin-top"                   ),
		FO_MARGIN_RIGHT                     (ODF_NAMESPACE_ID.FO     ,"margin-right"                 ),
		FO_MARGIN_BOTTOM                    (ODF_NAMESPACE_ID.FO     ,"margin-bottom"                ),
		FO_LINE_HEIGHT                      (ODF_NAMESPACE_ID.FO     ,"line-height"                  ),
		FO_WRAP_OPTION                      (ODF_NAMESPACE_ID.FO     ,"wrap-option"                  ),
		FO_LANGUAGE                         (ODF_NAMESPACE_ID.FO     ,"language"                     ),
		FO_COUNTRY                          (ODF_NAMESPACE_ID.FO     ,"country"                      ),
		FO_KEEP_TOGETHER                    (ODF_NAMESPACE_ID.FO     ,"keep-together"                ),
		FO_KEEP_WITH_NEXT                   (ODF_NAMESPACE_ID.FO     ,"keep-with-next"               ),
		FO_HYPHENATE                        (ODF_NAMESPACE_ID.FO     ,"hyphenate"                    ),
		FO_HYPHENATION_LADDER_COUNT         (ODF_NAMESPACE_ID.FO     ,"hyphenation-ladder-count"     ),
		FO_HYPHENATION_PUSH_CHAR_COUNT      (ODF_NAMESPACE_ID.FO     ,"hyphenation-push-char-count"  ),
		LOEXT_CONTEXTUAL_SPACING            (ODF_NAMESPACE_ID.LOEXT  ,"contextual-spacing"           );

		private String prefix = null;
		private String localName = "";

		@SuppressWarnings("hiding")
		ODF_ATTRIBUTE_ID(final ODF_NAMESPACE_ID namespaceID,final String localName)
		{

			this.prefix    = namespaceID.getPrefix();
			this.localName = localName == null ? "" : localName .trim();

		}

		ODF_ATTRIBUTE_ID(final ODF_NAMESPACE_ID namespaceID)
		{

			this.prefix    = "xmlns";
			this.localName = namespaceID.getPrefix();

		}

		@Override
		public final ODF_NAMESPACE_ID getNamespaceID()
		{

			return ODF_NAMESPACE_ID.findByPrefix(this.getPrefix());

		}

		@Override
		public final String getPrefix()
		{

			return this.prefix == null ? "" : this.prefix.trim();

		}

		@Override
		public final String getLocalName()
		{

			return this.localName;

		}

		@Override
		public final String getName()
		{

			return "".equals(this.localName) ? "" : ("".equals(this.prefix) ? "" : this.prefix + ":") + this.localName;

		}

		@Override
		public final IODFAttribute getAttribute(final IODFAttributeValue value)
		{

			if (value == null) throw new IllegalArgumentException("Invalid attribute value");

			return new ODFAttribute()
			{

				@Override
				public final ODF_ATTRIBUTE_ID getAttributeID()
				{

					return ODF_ATTRIBUTE_ID.this;

				}

				@Override
				public final IODFAttributeValue getValue()
				{

					return value;

				}

			};

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
