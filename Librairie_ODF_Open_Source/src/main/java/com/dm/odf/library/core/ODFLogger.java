package com.dm.odf.library.core;

/**
 * <p>Trace programme</p>
 * @author Didier
 */
public final class ODFLogger
{

	private static final ODFLogger instance = new ODFLogger();

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	private ODFLogger()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	/**
	 * <p>Obtention instance singleton</p>
	 * @return Instance singleton
	 */
	public static final ODFLogger getInstance()
	{

		return instance;

	}

	/**
	 * <p>Trace erreur</p>
	 * @param error Erreur à tracer
	 */
	public static final synchronized void log(final Throwable error)
	{

		try
		{

			if (error == null) return;

			error.printStackTrace(System.err);

			System.err.flush();

		}
		catch (final Throwable exception)
		{

			exception.printStackTrace(System.err);

			System.err.flush();

		}

	}

	/**
	 * <p>Trace message</p>
	 * @param message Message à tracer
	 */
	public static final synchronized void log(final String message)
	{

		try
		{

			if ((message == null ? "" : message.trim()).length() == 0) return;

			System.out.println(message);

			System.out.flush();

		}
		catch (final Throwable exception)
		{

			exception.printStackTrace(System.err);

			System.err.flush();

		}

	}

}
