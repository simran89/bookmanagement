import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection2 {

	
		public static Connection getDBConnection(String db)throws Exception
		{
			Connection conn = null;
			try
			{
			//	127.0.0.1 means server is running on same machine
				
				if(db.equalsIgnoreCase("mysql"))
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1/Class1","root","password");
					return conn;
				}
				else
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
				return conn;
					
				}
				
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
				throw e;
			}
			
	
	}
	
}
