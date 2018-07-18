import java.sql.Connection;
import java.sql.ResultSet;

public class Business {

	Connection conn;
	
	public ResultSet doShowBooks() throws Exception
	{
		conn  = DBConnection.getDBConnection("oracle");
		
		ResultSet resultSet =UsersTable.getUsersByRecord(conn);
		return resultSet;
		
	}
}
