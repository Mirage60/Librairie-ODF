package com.dm.odf.library.test;

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

			final IODFTextDocument document = new ODFTextDocument();

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
