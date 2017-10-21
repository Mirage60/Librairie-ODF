package com.dm.odf.library.elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.dm.odf.library.core.ODFConstants.ODF_ATTRIBUTE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_ELEMENT_ID;
import com.dm.odf.library.core.ODFElement;
import com.dm.odf.library.interfaces.IODFAttributeValue;
import com.dm.odf.library.interfaces.IODFNode;
import com.dm.odf.library.interfaces.elements.IODFStyleFootnoteSepElement;
import com.dm.odf.library.interfaces.elements.IODFStylePageLayoutPropertiesElement;

public abstract class ODFStylePageLayoutPropertiesElement extends ODFElement implements IODFStylePageLayoutPropertiesElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFStylePageLayoutPropertiesElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFAttributeValue getPageWidth();

	@Override
	public abstract IODFAttributeValue getPageHeight();

	@Override
	public abstract IODFAttributeValue getNumericFormat();

	@Override
	public abstract IODFAttributeValue getPrintOrientation();

	@Override
	public abstract IODFAttributeValue getMargintop();

	@Override
	public abstract IODFAttributeValue getMarginBottom();

	@Override
	public abstract IODFAttributeValue getMarginLeft();

	@Override
	public abstract IODFAttributeValue getMarginRight();

	@Override
	public abstract IODFAttributeValue getWritingMode();

	@Override
	public abstract IODFAttributeValue getFootnoteMaxHeight();

	@Override
	public abstract IODFStyleFootnoteSepElement getFootnoteSeparator();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.STYLE_PAGE_LAYOUT_PROPERTIES;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
	{

		final IODFAttributeValue pageWidth         = this.getPageWidth();
		final IODFAttributeValue pageHeight        = this.getPageHeight();
		final IODFAttributeValue numericFormat     = this.getNumericFormat();
		final IODFAttributeValue printOrientation  = this.getPrintOrientation();
		final IODFAttributeValue marginLeft        = this.getMarginLeft();
		final IODFAttributeValue marginTop         = this.getMargintop();
		final IODFAttributeValue marginRight       = this.getMarginRight();
		final IODFAttributeValue marginBottom      = this.getMarginBottom();
		final IODFAttributeValue writingMode       = this.getWritingMode();
		final IODFAttributeValue footnoteMaxHeight = this.getFootnoteMaxHeight();

		if (pageWidth         == null) throw new Exception("Failed to retrieve page width value"       );
		if (pageHeight        == null) throw new Exception("Failed to retrieve page height value"      );
		if (numericFormat     == null) throw new Exception("Failed to retrieve numeric format value"   );
		if (printOrientation  == null) throw new Exception("Failed to retrieve print orientation value");
		if (marginLeft        == null) throw new Exception("Failed to retrieve margin left value"      );
		if (marginTop         == null) throw new Exception("Failed to retrieve margin top value"       );
		if (marginRight       == null) throw new Exception("Failed to retrieve margin right value"     );
		if (marginBottom      == null) throw new Exception("Failed to retrieve margin bottom value"    );
		if (writingMode       == null) throw new Exception("Failed to retrieve writing mode value"     );
		if (footnoteMaxHeight == null) throw new Exception("Failed to retrieve footnote value"         );

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		attributes.put(ODF_ATTRIBUTE_ID.FO_PAGE_WIDTH             ,pageWidth        );
		attributes.put(ODF_ATTRIBUTE_ID.FO_PAGE_HEIGHT            ,pageHeight       );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_NUM_FORMAT          ,numericFormat    );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_PRINT_ORIENTATION   ,printOrientation );
		attributes.put(ODF_ATTRIBUTE_ID.FO_MARGIN_LEFT            ,marginLeft       );
		attributes.put(ODF_ATTRIBUTE_ID.FO_MARGIN_TOP             ,marginTop        );
		attributes.put(ODF_ATTRIBUTE_ID.FO_MARGIN_RIGHT           ,marginRight      );
		attributes.put(ODF_ATTRIBUTE_ID.FO_MARGIN_BOTTOM          ,marginBottom     );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_WRITING_MODE        ,writingMode      );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_FOOTNOTE_MAX_HEIGHT ,footnoteMaxHeight);

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes() throws Exception
	{

		final IODFStyleFootnoteSepElement separator = this.getFootnoteSeparator();

		if (separator == null) throw new Exception("Failed to retrieve footnote separator");

		final List<IODFNode> nodes = new ArrayList<>();

		nodes.add(separator);

		return Collections.unmodifiableList(nodes);

	}

}
