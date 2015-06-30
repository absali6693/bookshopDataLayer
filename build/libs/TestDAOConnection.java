import java.sql.*;
import com.thinking.machines.bookshop.dao.*;
class TestDAOConnection
{
public static void main(String gg[])
{
try
{
Connection connection=DAOConnection.getConnection();
connection.close();
System.out.println("OK");
}catch(Exception exception)
{
System.out.println(exception);
}

}
}