package com.thinking.machines.bookshop.dao;
import java.util.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
import java.sql.*;
public class AuthorDAO implements AuthorDAOInterface
{
public void add(AuthorInterface authorInterface) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from author where name=?");
preparedStatement.setString(1,authorInterface.getName());
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Author : "+authorInterface.getName()+" exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("insert into author (name,city) values(?,?)");
preparedStatement.setString(1,authorInterface.getName());
preparedStatement.setString(2,authorInterface.getCity());
preparedStatement.executeUpdate();
resultSet=preparedStatement.getGeneratedKeys();
if(resultSet.next())
{
authorInterface.setCode(resultSet.getInt(1));
}
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println("AuthorDAO : public void add(AuthorInterface authorInterface) throws DAOException "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
public void update(AuthorInterface authorInterface) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from author where code=?");
preparedStatement.setInt(1,authorInterface.getCode());
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Author code : "+authorInterface.getCode()+" does not exist.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("select code from author where name=? and code<>?");
preparedStatement.setString(1,authorInterface.getName());
preparedStatement.setInt(2,authorInterface.getCode());
resultSet=preparedStatement.executeQuery();
if(resultSet.next())
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Author : "+authorInterface.getName()+" exists.");
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("update author set name=?,city=? where code=?");
preparedStatement.setString(1,authorInterface.getName());
preparedStatement.setString(2,authorInterface.getCity());
preparedStatement.setInt(3,authorInterface.getCode());
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println("public void update(AuthorInterface authorInterface) throws DAOException "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
public void remove(int code) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from author where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid author code : "+code);
}
resultSet.close();
preparedStatement.close();
preparedStatement=connection.prepareStatement("delete from author where code=?");
preparedStatement.setInt(1,code);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
}catch(SQLException sqlException)
{
System.out.println("public void remove(int code) throws DAOException : "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
public AuthorInterface get(int code) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from author where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid author code : "+code);
}
String name=resultSet.getString("name").trim();
String city=resultSet.getString("city").trim();
AuthorInterface authorInterface=new Author();
authorInterface.setCode(code);
authorInterface.setName(name);
authorInterface.setCity(city);
return authorInterface;


}catch(SQLException sqlException)
{
System.out.println("public AuthorInterface get(int code) throws DAOException : "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
public AuthorInterface getByName(String name) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select * from author where name=?");
preparedStatement.setString(1,name);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("Invalid Author name : "+name);
}
int code=resultSet.getInt("code");
String city=resultSet.getString("city").trim();
AuthorInterface authorInterface=new Author();
authorInterface.setCode(code);
authorInterface.setName(name);
authorInterface.setCity(city);
resultSet.close();
preparedStatement.close();
connection.close();
return authorInterface;
}catch(SQLException sqlException)
{
System.out.println("public AuthorInterface getByName(String name) throws DAOException : "+sqlException);
throw new DAOException(sqlException.getMessage());
}


}
public ArrayList<AuthorInterface> get() throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select * from author order by name");
if(resultSet.next()==false)
{
resultSet.close();
statement.close();
connection.close();
throw new DAOException("No authors");
}
ArrayList<AuthorInterface> authors=new ArrayList<AuthorInterface>();
AuthorInterface authorInterface;
do
{
authorInterface=new Author();
authorInterface.setCode(resultSet.getInt("code"));
authorInterface.setName(resultSet.getString("name").trim());
authorInterface.setCity(resultSet.getString("city").trim());
authors.add(authorInterface);
}while(resultSet.next());
resultSet.close();
statement.close();
connection.close();
return authors;
}catch(SQLException sqlException)
{
System.out.println("public ArrayList<AuthorInterface> get() throws DAOException : "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
public ArrayList<String> getCities() throws DAOException
{
try{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select distinct city from author order by city");
if(resultSet.next()==false)
{
resultSet.close();
statement.close();
connection.close();
throw new DAOException("No cities");
}
ArrayList<String> cities=new ArrayList<String>();

AuthorInterface authorInterface;
do
{
authorInterface=new Author();
authorInterface.setCity(resultSet.getString("city").trim());
cities.add(resultSet.getString("city").trim());
}while(resultSet.next());
resultSet.close();
statement.close();
connection.close();
return cities;
 
}catch(SQLException sqlException)
{
System.out.println("public ArrayList<AuthorInterface> getCities() throws DAOException : "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}


public ArrayList<AuthorInterface> getByCity(String city) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from author where city=? order by name");
preparedStatement.setString(1,city);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("No authors in city : "+city);
}
ArrayList<AuthorInterface> authors=new ArrayList<AuthorInterface>();
AuthorInterface authorInterface;
do
{
authorInterface=new Author();
authorInterface.setCode(resultSet.getInt("code"));
authorInterface.setName(resultSet.getString("name").trim());
authorInterface.setCity(resultSet.getString("city").trim());
authors.add(authorInterface);
}while(resultSet.next());
resultSet.close();
preparedStatement.close();
connection.close();
return authors;
}catch(SQLException sqlException)
{
System.out.println("public ArrayList<AuthorInterface> getByCity(String city) throws DAOException : "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
public long getCount() throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
Statement statement=connection.createStatement();
ResultSet resultSet=statement.executeQuery("select count(*) as cnt from author");
resultSet.next();
long count=resultSet.getLong("cnt");
resultSet.close();
statement.close();
connection.close();
return count;
}catch(SQLException sqlException)
{
System.out.println("public long getCount() throws DAOException : "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}


}
public boolean exists(int code) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from author where code=?");
preparedStatement.setInt(1,code);
ResultSet resultSet=preparedStatement.executeQuery();
boolean b=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
return b;
}catch(SQLException sqlException)
{
System.out.println("public boolean exists(int code) throws DAOException "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
public boolean existsByName(String name) throws DAOException
{
try
{
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement;
preparedStatement=connection.prepareStatement("select code from author where name=?");
preparedStatement.setString(1,name);
ResultSet resultSet=preparedStatement.executeQuery();
boolean b=resultSet.next();
resultSet.close();
preparedStatement.close();
connection.close();
return b;
}catch(SQLException sqlException)
{
System.out.println("public boolean existsByName(String name) throws DAOException "+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}

public ArrayList<AuthorInterface> getByRecordNumber(int fromRecordNumber,int uptoRecordNumber,String orderBy) throws DAOException
{ 
if(fromRecordNumber<1 || uptoRecordNumber<fromRecordNumber)
{ throw new DAOException("No authors");
}
String orderByClause="";
if(orderBy!=null && orderBy.trim().length()>0)
{
orderByClause=" order by "+orderBy+" ";
} try
{
int startFrom=fromRecordNumber-1;
int numberOfRecords=uptoRecordNumber-fromRecordNumber+1;
Connection connection=DAOConnection.getConnection();
PreparedStatement preparedStatement=connection.prepareStatement("select * from author"+orderByClause+" limit ?,?");
preparedStatement.setInt(1,startFrom);
preparedStatement.setInt(2,numberOfRecords);
ResultSet resultSet=preparedStatement.executeQuery();
if(resultSet.next()==false)
{
resultSet.close();
preparedStatement.close();
connection.close();
throw new DAOException("No authors");
}
ArrayList<AuthorInterface> authors=new ArrayList<AuthorInterface>();
AuthorInterface authorInterface;
do
{ authorInterface=new Author();
authorInterface.setCode(resultSet.getInt("code"));
authorInterface.setName(resultSet.getString("name").trim());
authorInterface.setCity(resultSet.getString("city").trim());
authors.add(authorInterface);
}while(resultSet.next());
resultSet.close();
preparedStatement.close();
connection.close();
return authors;
}catch(SQLException sqlException)
{
System.out.println("public ArrayList<AuthorInterface> getByRecordNumber(int fromRecordNumber,int uptoRecordNumber,String orderBy) throws DAOException :"+sqlException.getMessage());
throw new DAOException(sqlException.getMessage());
}
}
}