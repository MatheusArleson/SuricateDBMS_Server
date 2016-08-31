package br.com.xavier.suricate.dbms.impl.table.data;

import br.com.xavier.suricate.dbms.abstractions.table.data.AbstractColumnEntry;

public final class ColumnEntry
		extends AbstractColumnEntry {
	
	private static final long serialVersionUID = -1246714275187831700L;

	public ColumnEntry() {
		super();
	}
	
	public ColumnEntry(Short contentSize, byte[] content) {
		super(contentSize, content);
	}

}
