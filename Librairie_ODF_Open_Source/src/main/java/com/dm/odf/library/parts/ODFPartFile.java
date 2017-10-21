package com.dm.odf.library.parts;

import com.dm.odf.library.core.ODFConstants.ODF_DOCUMENT_TYPE_ID;
import com.dm.odf.library.core.ODFConstants.ODF_PART_FILE_ID;
import com.dm.odf.library.interfaces.IODFContent;
import com.dm.odf.library.interfaces.IODFDocument;
import com.dm.odf.library.interfaces.parts.IODFPartFile;

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

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final ODF_DOCUMENT_TYPE_ID getDocumentTypeID()
	{

		final IODFDocument document = this.getDocument();

		return document == null ? null : document.getDocumentTypeID();

	}

	@Override
	public final String getEntryName()
	{

		final String fileName = this.getFileName();

		return fileName == null ? "" : fileName.trim();

	}

	@Override
	public final String toString()
	{

		final IODFContent content = this.getContent();

		final String text = content == null ? "" : content.toString();

		return text == null ? "" : text.trim();

	}

}
