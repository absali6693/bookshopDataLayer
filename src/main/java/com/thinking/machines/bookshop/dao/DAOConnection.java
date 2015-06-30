package com.thinking.machines.bookshop.dao;
import java.sql.*;
public class DAOConnection 
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
}