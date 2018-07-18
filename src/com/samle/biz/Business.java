package com.samle.biz;
import java.sql.Connection;
import java.sql.ResultSet;

import com.sample.jdbc.DBConnection;
import com.sample.jdbc.UsersTable;

public class Business {

	Connection conn;
	static ResultSet resultSet;
	public void  doADDBooks(Book b) throws Exception
	{
		
		conn  = DBConnection.getDBConnection("mysql");
		UsersTable.insertBookRecord(b.bookid, b.booktitle, b.authorname, b.publisher,b.Edition, b.invoiceNo, b.invoicedate, b.cost, conn);

	
		
	}
}
