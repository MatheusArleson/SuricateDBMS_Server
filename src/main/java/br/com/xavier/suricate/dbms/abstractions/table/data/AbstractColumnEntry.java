package br.com.xavier.suricate.dbms.abstractions.table.data;

import java.io.IOException;
import java.util.Arrays;

import br.com.xavier.suricate.dbms.interfaces.table.data.IColumnEntry;

public class AbstractColumnEntry
		implements IColumnEntry {

	private static final long serialVersionUID = -5978555259748724952L;
	
	//XXX PROPERTIES
	private Short contentSize;
	private byte[] content;
	
	//XXX CONSTRUCTOR
	public AbstractColumnEntry(Short contentSize, byte[] content) {
		super();
		this.contentSize = contentSize;
		this.content = content;
	}
	
	public AbstractColumnEntry(byte[] bytes) throws IOException {
		fromByteArray(bytes);
	}
	
	//XXX OVERRIDE METHODS
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(content);
		result = prime * result + ((contentSize == null) ? 0 : contentSize.hashCode());
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
		AbstractColumnEntry other = (AbstractColumnEntry) obj;
		if (contentSize == null) {
			if (other.contentSize != null)
				return false;
		} else if (!contentSize.equals(other.contentSize))
			return false;
		if (!Arrays.equals(content, other.content))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AbstractColumnEntry [" 
			+ "contentSize=" + contentSize 
		+ "]";
	}

	//XXX GETTERS/SETTERS
	@Override
	public Short getContentSize() {
		return contentSize;
	}

	@Override
	public void setContentSize(Short size) {
		this.contentSize = size;
	}

	@Override
	public byte[] getContent() {
		return content;
	}

	@Override
	public void setContent(byte[] content) {
		this.content = content;
	}

}
