

import java.sql.*;


import java.sql.SQLException;

public class UsersTable {

	public static void insertRecord(int bookid,String booktitle ,String authorname,String publisher,String Edition,int InvoiceNo, Date invoicedate,double cost,Connection conn)throws SQLException
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
			stmt.setInt(6,InvoiceNo );
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
	public static ResultSet getUsersByRecord(Connection conn)throws SQLException
	{
		java.sql.PreparedStatement stmt = null;
		ResultSet resultSet = null;
		try
		{
			stmt = conn.prepareStatement("select * from book");
			
			
			 resultSet =(ResultSet) stmt.executeQuery();
			 
			 return resultSet;
//			 while(resultSet.next())
//			 {
//				 System.out.println(resultSet.getString("bookid"));//out parameters
//				 return resultSet;
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
}
