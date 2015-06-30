package com.thinking.machines.bookshop.dao.exceptions;
public class DAOException extends Exception implements java.io.Serializable
{
private String message;
public DAOException()
{
this.message=null;
}
public DAOException(String message)
{
this.message=message;
}
public String toString()
{
if(message==null)
{
return "com.thinking.machines.bookshop.dao.exceptions.DAOException";
}
else
{
return "com.thinking.machines.bookshop.dao.exceptions.DAOException: "+message;
}
}
public String getMessage()
{
return this.message;
}
}