package com.dm.odf.library.parts;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFAttributeValue;
import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_NAMESPACE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_PART_FILE_ID;
import com.dm.odf.library.core.ODFElement;
import com.dm.odf.library.elements.ODFStyleFontFaceElement;
import com.dm.odf.library.elements.ODFStyleFooterStyleElement;
import com.dm.odf.library.elements.ODFStyleFootnoteSepElement;
import com.dm.odf.library.elements.ODFStyleHeaderStyleElement;
import com.dm.odf.library.elements.ODFStyleMasterPageElement;
import com.dm.odf.library.elements.ODFStylePageLayoutElement;
import com.dm.odf.library.elements.ODFStylePageLayoutPropertiesElement;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFElement;
import com.dm.odf.library.interfaces.IODFNode;
import com.dm.odf.library.interfaces.elements.IODFStyleFooterStyleElement;
import com.dm.odf.library.interfaces.elements.IODFStyleFootnoteSepElement;
import com.dm.odf.library.interfaces.elements.IODFStyleHeaderStyleElement;
import com.dm.odf.library.interfaces.elements.IODFStylePageLayoutPropertiesElement;
import com.dm.odf.library.interfaces.parts.IODFStylesFile;
import com.dm.odf.library.xml.ODFXmlContent;

public abstract class ODFStylesFile extends ODFPartFile implements IODFStylesFile
{

	public static final String FILE_NAME = "styles.xml";

	protected static final String PAGE_LAYOUT_NAME = "Mpm1";

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFStylesFile()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_PART_FILE_ID getPartFileID()
	{

		return ODF_PART_FILE_ID.STYLES;

	}

	@Override
	public final String getFileName()
	{

		return FILE_NAME.trim();

	}

	@Override
	public final IODFContent getContent()
	{

		return new ODFXmlContent()
		{

			@Override
			public final ODF_MIME_TYPE_ID getMimeTypeID()
			{

				return ODF_MIME_TYPE_ID.XML;

			}

			@Override
			public final Charset getCharset()
			{

				return StandardCharsets.UTF_8;

			}

			@Override
			public final IODFElement getRootElement()
			{

				return new RootElement();

			}

		};

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class RootElement extends ODFElement
	{

		public RootElement()
		{

			super();

		}

		@Override
		public final ODF_ELEMENT_ID getElementID()
		{

			return ODF_ELEMENT_ID.OFFICE_DOCUMENT_CONTENT;

		}

		@Override
		public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
		{

			final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

			// Espaces de noms

			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_OFFICE    ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.OFFICE   ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_STYLE     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.STYLE    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_TEXT      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.TEXT     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_TABLE     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.TABLE    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_DRAW      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.DRAW     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_FO        ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.FO       ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_XLINK     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.XLINK    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_DC        ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.DC       ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_META      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.META     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_NUMBER    ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.NUMBER   ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_SVG       ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.SVG      ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_CHART     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.CHART    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_DR3D      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.DR3D     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_MATH      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.MATH     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_FORM      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.FORM     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_SCRIPT    ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.SCRIPT   ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_OOO       ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.OOO      ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_OOOW      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.OOOW     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_OOOC      ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.OOOC     ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_DOM       ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.DOM      ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_XFORMS    ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.XFORMS   ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_XSD       ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.XSD      ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_XSI       ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.XSI      ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_RPT       ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.RPT      ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_OF        ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.OF       ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_XHTML     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.XHTML    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_GRDDL     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.GRDDL    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_OFFICEOOO ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.OFFICEOOO));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_TABLEOOO  ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.TABLEOOO ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_DRAWOOO   ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.DRAWOOO  ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_CALCEXT   ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.CALCEXT  ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_LOEXT     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.LOEXT    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_FIELD     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.FIELD    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_FORMX     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.FORMX    ));
			attributes.put(ODF_ATTRIBUTE_ID.XMLNS_CSS3T     ,ODFAttributeValue.newInstance(ODF_NAMESPACE_ID.CSS3T    ));

			// Attributs

			attributes.put(ODF_ATTRIBUTE_ID.OFFICE_VERSION,ODFAttributeValue.newInstance("1.2"));

			return Collections.unmodifiableMap(attributes);

		}

		@Override
		public final List<IODFNode> getNodes()
		{

			final List<IODFNode> nodes = new ArrayList<>();

			nodes.add(new ScriptsElement()             );
			nodes.add(new FontFaceDeclarationsElement());
			nodes.add(new StylesElement()              );
			nodes.add(new AutomaticStylesElement()     );
			nodes.add(new MasterStylesElement()        );

			return Collections.unmodifiableList(nodes);

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class ScriptsElement extends ODFElement
	{

		public ScriptsElement()
		{

			super();

		}

		@Override
		public final ODF_ELEMENT_ID getElementID()
		{

			return ODF_ELEMENT_ID.OFFICE_SCRIPTS;

		}

		@Override
		public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
		{

			return Collections.unmodifiableMap(new Hashtable<>());

		}

		@Override
		public final List<IODFNode> getNodes()
		{

			final List<IODFNode> nodes = new ArrayList<>();

			return Collections.unmodifiableList(nodes);

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class FontFaceDeclarationsElement extends ODFElement
	{

		public FontFaceDeclarationsElement()
		{

			super();

		}

		@Override
		public final ODF_ELEMENT_ID getElementID()
		{

			return ODF_ELEMENT_ID.OFFICE_FONT_FACE_DECLS;

		}

		@Override
		public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
		{

			return Collections.unmodifiableMap(new Hashtable<>());

		}

		@Override
		public final List<IODFNode> getNodes()
		{

			final List<IODFNode> nodes = new ArrayList<>();

			nodes.add(ODFStyleFontFaceElement.newInstance("Mangal1","Mangal"                                        ));
			nodes.add(ODFStyleFontFaceElement.newInstance("Liberation Serif","'Liberation Serif'","Roman","Variable"));
			nodes.add(ODFStyleFontFaceElement.newInstance("Liberation Sans","'Liberation Sans'","swiss","variable"  ));
			nodes.add(ODFStyleFontFaceElement.newInstance("Mangal","Mangal","system","variable"                     ));
			nodes.add(ODFStyleFontFaceElement.newInstance("Microsoft YaHei","'Microsoft YaHei'","system","variable" ));
			nodes.add(ODFStyleFontFaceElement.newInstance("SimSun","SimSun","system","variable"                     ));

			return Collections.unmodifiableList(nodes);

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class AutomaticStylesElement extends ODFElement
	{

		public AutomaticStylesElement()
		{

			super();

		}

		@Override
		public final ODF_ELEMENT_ID getElementID()
		{

			return ODF_ELEMENT_ID.OFFICE_AUTOMATIC_STYLES;

		}

		@Override
		public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
		{

			return Collections.unmodifiableMap(new Hashtable<>());

		}

		@Override
		public final List<IODFNode> getNodes()
		{

			final List<IODFNode> nodes = new ArrayList<>();

			nodes.add(new ODFStylePageLayoutElement()
			{

				@Override
				public final IODFAttributeValue getLayoutName()
				{

					return ODFAttributeValue.newInstance(PAGE_LAYOUT_NAME);

				}

				@Override
				public final IODFStylePageLayoutPropertiesElement getPageLayoutProperties()
				{

					return new PageLayoutProperties();

				}

				@Override
				public final IODFStyleHeaderStyleElement getHeaderStyle()
				{

					return new HeaderStyle();

				}

				@Override
				public final IODFStyleFooterStyleElement getFooterStyle()
				{

					return new FooterStyle();

				}

			});

			return Collections.unmodifiableList(nodes);

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class StylesElement extends ODFElement
	{

		public StylesElement()
		{

			super();

		}

		@Override
		public final ODF_ELEMENT_ID getElementID()
		{

			return ODF_ELEMENT_ID.OFFICE_STYLES;

		}

		@Override
		public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
		{

			return Collections.unmodifiableMap(new Hashtable<>());

		}

		@Override
		public final List<IODFNode> getNodes()
		{

			final List<IODFNode> nodes = new ArrayList<>();

			return Collections.unmodifiableList(nodes);

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class MasterStylesElement extends ODFElement
	{

		public MasterStylesElement()
		{

			super();

		}

		@Override
		public final ODF_ELEMENT_ID getElementID()
		{

			return ODF_ELEMENT_ID.OFFICE_MASTER_STYLES;

		}

		@Override
		public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap()
		{

			return Collections.unmodifiableMap(new Hashtable<>());

		}

		@Override
		public final List<IODFNode> getNodes()
		{

			final List<IODFNode> nodes = new ArrayList<>();

			nodes.add(new ODFStyleMasterPageElement()
			{

				@Override
				public final IODFAttributeValue getMasterName()
				{

					return ODFAttributeValue.newInstance("Standard");

				}

				@Override
				public final IODFAttributeValue getPageLayoutName()
				{

					return ODFAttributeValue.newInstance(PAGE_LAYOUT_NAME);

				}

			});

			return Collections.unmodifiableList(nodes);

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class PageLayoutProperties extends ODFStylePageLayoutPropertiesElement
	{

		public PageLayoutProperties()
		{

			super();

		}

		@Override
		public final IODFAttributeValue getPageWidth()
		{

			return ODFAttributeValue.newInstance("21.001cm");

		}

		@Override
		public final IODFAttributeValue getPageHeight()
		{

			return ODFAttributeValue.newInstance("29.7cm");

		}

		@Override
		public final IODFAttributeValue getNumericFormat()
		{

			return ODFAttributeValue.newInstance("1");

		}

		@Override
		public final IODFAttributeValue getPrintOrientation()
		{

			return ODFAttributeValue.newInstance("portrait");

		}

		@Override
		public final IODFAttributeValue getMarginLeft()
		{

			return ODFAttributeValue.newInstance("2cm");

		}

		@Override
		public final IODFAttributeValue getMargintop()
		{

			return ODFAttributeValue.newInstance("2cm");

		}

		@Override
		public final IODFAttributeValue getMarginRight()
		{

			return ODFAttributeValue.newInstance("2cm");

		}

		@Override
		public final IODFAttributeValue getMarginBottom()
		{

			return ODFAttributeValue.newInstance("2cm");

		}

		@Override
		public final IODFAttributeValue getWritingMode()
		{

			return ODFAttributeValue.newInstance("lr-tb");

		}

		@Override
		public final IODFAttributeValue getFootnoteMaxHeight()
		{

			return ODFAttributeValue.newInstance("0cm");

		}

		@Override
		public final IODFStyleFootnoteSepElement getFootnoteSeparator()
		{

			return new ODFStyleFootnoteSepElement()
			{

				@Override
				public final IODFAttributeValue getWidth()
				{

					return ODFAttributeValue.newInstance("0.018cm");

				}

				@Override
				public final IODFAttributeValue getDdistanceBeforeSeparator()
				{

					return ODFAttributeValue.newInstance("0.101cm");

				}

				@Override
				public final IODFAttributeValue getDistanceAfterSeparator()
				{

					return ODFAttributeValue.newInstance("0.101cm");

				}

				@Override
				public final IODFAttributeValue getLineStyle()
				{

					return ODFAttributeValue.newInstance("solid");

				}

				@Override
				public final IODFAttributeValue getAdjustment()
				{

					return ODFAttributeValue.newInstance("left");

				}

				@Override
				public final IODFAttributeValue getRelativeWidth()
				{

					return ODFAttributeValue.newInstance("25%");

				}

				@Override
				public final IODFAttributeValue getColor()
				{

					return ODFAttributeValue.newInstance("#000000");

				}

			};

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class HeaderStyle extends ODFStyleHeaderStyleElement
	{

		public HeaderStyle()
		{

			super();

		}

	}

	//==========================================================================
	// CLASSE INTERNE
	//==========================================================================

	private final class FooterStyle extends ODFStyleFooterStyleElement
	{

		public FooterStyle()
		{

			super();

		}

	}

}
