package com.sample.jdbc;


import java.sql.*;


import java.util.ArrayList;
import java.util.List;

import com.samle.biz.Book;

public class UsersTable {
	
	static ResultSet resultSet;
	
	public static void insertBookRecord(int bookid,String booktitle,String authorname,String publisher,String Edition,	int invoiceNo,Date invoicedate,	double cost,Connection conn) throws Exception
	{

		java.sql.PreparedStatement stmt = null;
		try
		{
			stmt = conn.prepareStatement("insert into book values(?,?,?,?,?,?,?,?)");
			stmt.setInt(1,bookid );//first value
			stmt.setString(2,booktitle);//second value
			stmt.setString(3,authorname );//third value
			stmt.setString(4,publisher );//fourth valur
			stmt.setString(5,Edition );
			stmt.setInt(6,invoiceNo );
			 
	
			stmt.setDate(7,invoicedate );
			stmt.setDouble(8,cost );

			stmt.executeUpdate();
			
			
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				stmt.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static void updateRecord(String username,String password,Connection conn)throws SQLException
	{
		PreparedStatement stmt = null;
		try
		{
			stmt = (PreparedStatement) conn.prepareStatement("update login1 set password =? where username =?");
			stmt.setString(1,password );
			stmt.setString(2,username);

			stmt.executeUpdate();
			System.out.println("updated values are for :"+username+"the passord is"+password);
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				stmt.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteeRecord(String username,Connection conn)throws SQLException
	{
		PreparedStatement stmt = null;
		try
		{
			stmt = (PreparedStatement) conn.prepareStatement("delete from login1 where username =?;");
			stmt.setString(1,username );
			stmt.executeUpdate();
			System.out.println("deleted values are for :"+username);
		}
		catch(Exception e)
		{
			throw e;
		}
		finally
		{
			try
			{
				stmt.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	public static List<Book> getUsersByRecord(Connection conn)throws SQLException
	{
		List<Book> books = new ArrayList<Book>();

		Statement stmt = null;
	
		
		
		try
		{
			String query = "select * from book";
		    stmt = conn.createStatement();
	      
			
			 resultSet = stmt.executeQuery(query);
			 
			
			 while(resultSet.next())
			 {
				 Book b = new Book();
			
				 b.setBookid(resultSet.getInt("bookid"));
				 System.out.println("users table"+resultSet.getInt("bookid"));
				 
				 b.setBooktitle(resultSet.getString("booktitle"));
				 System.out.println(resultSet.getString("booktitle"));
			
				 b.setAuthorname(resultSet.getString("authorname"));
				 System.out.println( resultSet.getString("authorname"));
				 
				 b.setPublisher(resultSet.getString("publisher"));
//				 System.out.println( resultSet.getString("publisher")); 
				 
				 b.setEdition(resultSet.getString("Edition"));
//				 System.out.println( resultSet.getString("Edition"));
				
				 b.setInvoiceNo(resultSet.getInt("InvoiceNo"));
//				 System.out.println(resultSet.getInt("InvoiceNo"));
				 
//				 System.out.println(resultSet.getDate("invoicedate"));
				java.sql.Date date = resultSet.getDate("invoicedate");
//				 java.util.Date dbSqlDateConverted = new java.util.Date(date.getTime());
				 b.setInvoicedate(date);
				 
//				 System.out.println( resultSet.getDouble("cost"));
				 b.setCost(resultSet.getDouble("cost"));
				 
				books.add(b);
			 }
		
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in select");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			try
			{
				stmt.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		 return books;
	}
	public static boolean validateLogin(String uid, String pwd, java.sql.Connection conn) {
		// TODO Auto-generated method stub
		
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try
		{
			stmt = conn.prepareStatement("select username,password from login1 where username =? And password =?");
			stmt.setString(1,uid );
			stmt.setString(2,pwd );//in Parametres
			
			 resultSet =(ResultSet) stmt.executeQuery();
			 
			 String username;
			 String pswd;
			 while(resultSet.next())
			 {
				username=resultSet.getString("username");
				pswd=resultSet.getString("password");
				 if((uid.equalsIgnoreCase(username)) &&(pwd.equalsIgnoreCase(pswd)))
						 {
					 		return true;
						 }
			 }

	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	
	}
	
	public static ResultSet getBooksByRecord(Connection conn)throws SQLException
	{
		
		ResultSet resultSet = null;
		Statement stmt = null;

		
		
		try
		{
			String query = "select * from book";
		    stmt = conn.createStatement();
	      
			
			 resultSet = stmt.executeQuery(query);
			 return resultSet;
			
//			 while(resultSet.next())
//			 {
//				 
//			
//				 b.setBookid(resultSet.getInt("bookid"));
////				 System.out.println(resultSet.getInt("bookid"));
//				 
//				 b.setBooktitle(resultSet.getString("booktitle"));
////				 System.out.println(resultSet.getString("booktitle"));
//			
//				 b.setAuthorname(resultSet.getString("authorname"));
////				 System.out.println( resultSet.getString("authorname"));
//				 
//				 b.setPublisher(resultSet.getString("publisher"));
////				 System.out.println( resultSet.getString("publisher")); 
//				 
//				 b.setEdition(resultSet.getString("Edition"));
////				 System.out.println( resultSet.getString("Edition"));
//				
//				 b.setInvoiceNo(resultSet.getInt("InvoiceNo"));
////				 System.out.println(resultSet.getInt("InvoiceNo"));
//				 
////				 System.out.println(resultSet.getDate("invoicedate"));
//				 b.setInvoicedate(resultSet.getDate("invoicedate"));
//				 
////				 System.out.println( resultSet.getDouble("cost"));
//				 b.setCost(resultSet.getDouble("cost"));
//				 
//				books.add(b);
//			 }
			 
			 
		}
		catch(Exception e)
		{
			System.out.println("Exception in select");
			e.printStackTrace();
			throw e;
		}
		finally
		{
			try
			{
				stmt.close();
				
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
}
