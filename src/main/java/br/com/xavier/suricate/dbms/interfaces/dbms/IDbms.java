package br.com.xavier.suricate.dbms.interfaces.dbms;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import br.com.xavier.suricate.dbms.interfaces.services.ITextSeparators;

public interface IDbms
		extends Serializable, ITableManager, IRowManager {
	
	File getWorkspace() throws IOException;
	void setWorkspace(File workspaceFolder) throws IOException;
	String dumpAllTablesData(ITextSeparators separators) throws IOException;
	String getBufferStatistics();
	void shutdown();

}
