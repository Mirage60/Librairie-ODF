package com.dm.odf.library.core;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFContentFile;
import com.dm.odf.library.xml.ODFXmlContent;

public abstract class ODFContentFile extends ODFPartFile implements IODFContentFile
{

	public static final String FILE_NAME = "content.xml";

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFContentFile()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

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

		};

	}

}
