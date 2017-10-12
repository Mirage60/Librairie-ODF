package com.dm.odf.library.core;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.activation.MimeType;

import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFStylesFile;
import com.dm.odf.library.xml.ODFXmlContent;

public abstract class ODFStylesFile extends ODFPartFile implements IODFStylesFile
{

	public static final String FILE_NAME = "styles.xml";

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
			public final MimeType getMimeType()
			{

				return null;

			}

			@Override
			public final Charset getCharset()
			{

				return StandardCharsets.UTF_8;

			}

		};

	}

}
