package cn.flight.page.admini;

import javax.swing.table.DefaultTableModel;

public class TableTest extends DefaultTableModel{
	private Object[][] object;
	private String[] string;
	public TableTest(Object[][] object, String[] string) {
		super(object,string);
	}
	
	

}
