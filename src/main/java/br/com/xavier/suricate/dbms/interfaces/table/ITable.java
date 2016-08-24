package br.com.xavier.suricate.dbms.interfaces.table;

import java.io.RandomAccessFile;
import java.util.Collection;

import br.com.xavier.suricate.dbms.interfaces.IDeserializable;
import br.com.xavier.suricate.dbms.interfaces.ISerializable;
import br.com.xavier.suricate.dbms.interfaces.table.data.ITableDataBlock;
import br.com.xavier.suricate.dbms.interfaces.table.header.ITableHeaderBlock;

public interface ITable 
		extends ISerializable, IDeserializable<ITable> {
	
	RandomAccessFile getFile();
	void setFile(RandomAccessFile file);
	ITableHeaderBlock getHeaderBlock();
	void setHeaderBlock(ITableHeaderBlock header);
	Collection<ITableDataBlock> getDataBlocks();
	void setDataBlocks(Collection<ITableDataBlock> blocks);

}
