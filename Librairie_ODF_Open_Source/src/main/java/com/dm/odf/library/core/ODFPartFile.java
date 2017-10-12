package com.dm.odf.library.core;

import com.dm.odf.library.core.ODFConstants.ODF_PART_FILE_ID;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFDocument;
import com.dm.odf.library.interfaces.IODFPartFile;

public abstract class ODFPartFile implements IODFPartFile
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFPartFile()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_PART_FILE_ID getPartFileID();

	@Override
	public abstract IODFDocument getDocument();

	@Override
	public abstract String getFileName();

	@Override
	public abstract IODFContent getContent();

}
