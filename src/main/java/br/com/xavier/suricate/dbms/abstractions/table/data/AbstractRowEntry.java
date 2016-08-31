package br.com.xavier.suricate.dbms.abstractions.table.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import br.com.xavier.suricate.dbms.interfaces.table.data.IColumnEntry;
import br.com.xavier.suricate.dbms.interfaces.table.data.IRowEntry;
import br.com.xavier.util.ObjectsUtils;

public class AbstractRowEntry 
		implements IRowEntry {

	private static final long serialVersionUID = -4174089309741988414L;
	
	//XXX PROPERTIES
	private Integer size;
	private Collection<IColumnEntry> columnsEntries;
	
	//XXX CONSTRUCTOR
	public AbstractRowEntry() {
		super();
	}
	
	public AbstractRowEntry(Collection<IColumnEntry> columnsEntries) {
		setColumnsEntries(columnsEntries);
	}
	
	public AbstractRowEntry(byte[] bytes) throws IOException {
		fromByteArray(bytes);
	}

	//XXX OVERRIDE METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((columnsEntries == null) ? 0 : columnsEntries.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractRowEntry other = (AbstractRowEntry) obj;
		if (columnsEntries == null) {
			if (other.columnsEntries != null)
				return false;
		} else if (!columnsEntries.equals(other.columnsEntries))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AbstractRowEntry [" 
			+ "size=" + size 
			+ ", columnsEntries=" + columnsEntries 
		+ "]";
	}
	
	@Override
	public void setColumnsEntries(Collection<IColumnEntry> columnsEntries) {
		Objects.requireNonNull(columnsEntries, "Columns entries collection instance must not be null");
		
		if(columnsEntries.isEmpty()){
			throw new IllegalArgumentException("Columns entries collection must not be empty.");
		}
		
		boolean anyNull = ObjectsUtils.anyNull(columnsEntries.toArray());
		if(anyNull){
			throw new IllegalArgumentException("Columns entries collections must not have null values.");
		}
		
		this.columnsEntries = columnsEntries;
		setRowEntrySize(columnsEntries);
	}

	private void setRowEntrySize(Collection<IColumnEntry> columnsEntries) {
		Integer entrySize = new Integer(0);
		for (IColumnEntry c : columnsEntries) {
			entrySize = entrySize + c.getContentSize(); 
		}
		
		this.size = entrySize;
	}

	//XXX GETTERS/SETTERS
	@Override
	public Integer getSize() {
		return new Integer(size);
	}
	
	@Override
	public Collection<IColumnEntry> getColumnsEntries() {
		return new ArrayList<>(columnsEntries);
	}

}
