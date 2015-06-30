import java.sql.*;
import java.util.*;
public class AddRecord
{

public static Connection getConnection()
{

Connection connection=null;
try
{
Class.forName("com.mysql.jdbc.Driver");
connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdb","booku","bookp");
}catch(Exception exception)
{
System.out.println(exception);
System.exit(0);
}
return connection;
}
public static void main(String gg[])
{
int i=0;
String addName=null;
String addCity=null;
try
{
Connection connection=getConnection();
while(i<1000){
addName="SomeName"+i;
addCity="SomeCity"+i;
PreparedStatement preparedStatement=connection.prepareStatement("insert into author (name,city) values(?,?)");
preparedStatement.setString(1,addName);
preparedStatement.setString(2,addCity);
preparedStatement.executeUpdate();
preparedStatement.close();
i++;
}
connection.close();
}catch(SQLException sqlException)
{
System.out.println("AuthorDAO : public void add(AuthorInterface authorInterface) throws DAOException "+sqlException.getMessage());
}
}
}