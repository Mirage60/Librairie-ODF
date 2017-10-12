package com.dm.odf.library.interfaces;

import java.io.OutputStreamWriter;

public interface IODFNode
{

	// Accesseurs en lecture

	public IODFWriter getWriter();

	// Méthodes

	public void write(OutputStreamWriter writer) throws Exception;

}
