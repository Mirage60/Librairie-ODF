package com.dm.odf.library.interfaces;

import java.io.File;

public interface IODFContent
{

	// Accesseurs en lecture

	public byte[] getData();

	// Méthodes

	public void save(File file) throws Exception;

}
