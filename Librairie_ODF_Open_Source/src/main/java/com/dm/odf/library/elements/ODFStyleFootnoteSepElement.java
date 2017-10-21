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

public abstract class ODFStyleFootnoteSepElement extends ODFElement implements IODFStyleFootnoteSepElement
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFStyleFootnoteSepElement()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract IODFAttributeValue getWidth();

	@Override
	public abstract IODFAttributeValue getDdistanceBeforeSeparator();

	@Override
	public abstract IODFAttributeValue getDistanceAfterSeparator();

	@Override
	public abstract IODFAttributeValue getLineStyle();

	@Override
	public abstract IODFAttributeValue getAdjustment();

	@Override
	public abstract IODFAttributeValue getRelativeWidth();

	@Override
	public abstract IODFAttributeValue getColor();

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_ELEMENT_ID getElementID()
	{

		return ODF_ELEMENT_ID.STYLE_FOOTNOTE_SEP;

	}

	@Override
	public final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> getAttributeMap() throws Exception
	{

		final IODFAttributeValue width           = this.getWidth();
		final IODFAttributeValue beforeSeparator = this.getDdistanceBeforeSeparator();
		final IODFAttributeValue afterSeparator  = this.getDistanceAfterSeparator();
		final IODFAttributeValue lineStyle       = this.getLineStyle();
		final IODFAttributeValue adjustment      = this.getAdjustment();
		final IODFAttributeValue relativeWidth   = this.getRelativeWidth();
		final IODFAttributeValue color           = this.getColor();

		if (width           == null ) throw new Exception("Failed to retrieve width value"           );
		if (beforeSeparator == null ) throw new Exception("Failed to retrieve before separator value");
		if (afterSeparator  == null ) throw new Exception("Failed to retrieve after separator value" );
		if (lineStyle       == null ) throw new Exception("Failed to retrieve line style value"      );
		if (adjustment      == null ) throw new Exception("Failed to retrieve adjustment value"      );
		if (relativeWidth   == null ) throw new Exception("Failed to retrieve relative width value"  );
		if (color           == null ) throw new Exception("Failed to retrieve color value"           );

		final Map<ODF_ATTRIBUTE_ID,IODFAttributeValue> attributes = new Hashtable<>();

		attributes.put(ODF_ATTRIBUTE_ID.STYLE_WIDTH               ,width          );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_DISTANCE_BEFORE_SEP ,beforeSeparator);
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_DISTANCE_AFTER_SEP  ,afterSeparator );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_LINE_STYLE          ,lineStyle      );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_ADJUSTMENT          ,adjustment     );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_REL_WIDTH           ,relativeWidth  );
		attributes.put(ODF_ATTRIBUTE_ID.STYLE_COLOR               ,color          );

		return Collections.unmodifiableMap(attributes);

	}

	@Override
	public final List<IODFNode> getNodes()
	{

		return Collections.unmodifiableList(new ArrayList<>());

	}

}
