package com.dm.odf.library.core;

import java.util.Iterator;

/**
 * <p>Itérateur de substitution</p>
 * @author Didier
 */
public final class ODFNullIterator<T> implements Iterator<T>
{

	//==========================================================================
	// CONSTRUCTEURS
	//==========================================================================

	public ODFNullIterator()
	{

		super();

	}

	//==========================================================================
	// METHODES
	//==========================================================================

	@Override
	public final boolean hasNext()
	{

		return false;

	}

	@Override
	public final T next()
	{

		return null;

	}

}