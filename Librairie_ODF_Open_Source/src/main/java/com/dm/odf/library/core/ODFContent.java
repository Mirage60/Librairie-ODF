package com.dm.odf.library.core;

import java.io.File;
import java.io.FileOutputStream;

import javax.activation.MimeType;

import com.dm.odf.library.core.ODFConstants.ODF_MIME_TYPE_ID;
import com.dm.odf.library.interfaces.IODFContent;

public abstract class ODFContent implements IODFContent
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	protected ODFContent()
	{

		super();

	}

	//==========================================================================
	// METHODES ABSTRAITES
	//==========================================================================

	@Override
	public abstract ODF_MIME_TYPE_ID getMimeTypeID();

	@Override
	public abstract byte[] getData() throws Exception;

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final MimeType getMimeType()
	{

		final ODF_MIME_TYPE_ID mimeTypeID = this.getMimeTypeID();

		return mimeTypeID == null ? null : mimeTypeID.getMimeType();

	}

	@SuppressWarnings("resource")
	@Override
	public final void save(final File file) throws Exception
	{

		if (file == null) throw new IllegalArgumentException("Invalid file instance");

		final byte[] data = this.getData();

		final int length = data == null ? 0 : data.length;

		final File directory = file.getParentFile();

		if (directory == null) throw new Exception("Failed to retrieve directory instance");

		if (directory.exists())
		{

			if (directory.isDirectory() == false) throw new Exception(directory.getAbsolutePath() + " is not a valid directory"        );
			if (directory.canWrite()    == false) throw new Exception("Write access denied to directory " + directory.getAbsolutePath());

		}
		else
		{

			if (directory.mkdirs() == false) throw new Exception("Failed to create directory " + directory.getAbsolutePath());

		}

		final FileOutputStream outputStream = new FileOutputStream(file);

		try
		{

			if (length > 0)
			{

				outputStream.write(data,0,length);

			}

		}
		finally
		{

			outputStream.flush();
			outputStream.close();

		}

		final boolean completed = file.exists() ? file.isFile() ? file.length() == length : false : false;

		if (completed == false) throw new Exception("Failed to create file " + file.getAbsolutePath());

	}

}
