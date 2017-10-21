package com.dm.odf.library.test;

import java.io.File;

import com.dm.odf.library.core.ODFLogger;
import com.dm.odf.library.core.ODFTextDocument;
import com.dm.odf.library.interfaces.IODFTextDocument;
import com.dm.odf.library.interfaces.parts.IODFContentFile;

public final class ODFDocumentTest
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	public ODFDocumentTest()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	public static final void main(final String[] arguments)
	{

		try
		{

			System.out.println("Processing...");
			System.out.println();

			final File directory = new File(System.getProperty("user.home"));
			final File file      = new File(directory,"Tests/ODF/Demo.odt");

			final IODFTextDocument document = new ODFTextDocument();

			final IODFContentFile contentFile = document.getContentFile();

			if (contentFile == null) throw new Exception("Failed to retrieve content file instance");

			System.out.println(contentFile.toString());
			System.out.println();

			document.save(file);

			System.out.println("File [" + file.getAbsolutePath() + "] created OK.");
			System.out.println();

			System.out.println("Completed OK.");
			System.out.println();

			System.exit(0);

		}
		catch (final Throwable exception)
		{

			ODFLogger.log(exception);

			System.exit(1);

		}

	}

}
