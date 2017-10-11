package com.dm.odf.library.test;

import java.io.File;

import com.dm.odf.library.core.ODFTextDocument;
import com.dm.odf.library.interfaces.IODFTextDocument;

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

			document.save(file);

			System.out.println("Completed OK.");
			System.out.println();

			System.exit(0);

		}
		catch (final Throwable exception)
		{

			exception.printStackTrace();

			System.exit(1);

		}

	}

}
