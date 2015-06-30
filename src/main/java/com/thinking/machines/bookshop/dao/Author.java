package com.thinking.machines.bookshop.dao;
import com.thinking.machines.bookshop.dao.interfaces.*;
public class Author implements AuthorInterface
{
private int code;
private String name;
private String city;
public Author()
{
code=0;
name=null;
city=null;
}
public void setCode(int code)
{
this.code=code;
}
public int getCode()
{
return this.code;
}
public void setName(String name)
{
this.name=name;
}
public String getName()
{
return this.name;
}
public void setCity(String city)
{
this.city=city;
}
public String getCity()
{
return this.city;
}
public boolean equals(Object object)
{
if((object instanceof Author)==false) return false;
Author author=(Author)object;
return this.code==author.code;
}
public int compareTo(AuthorInterface authorInterface)
{
return this.name.compareTo(authorInterface.getName());
}
}