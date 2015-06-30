package com.thinking.machines.bookshop.dao.interfaces;
import java.io.*;
public interface AuthorInterface extends Serializable,Comparable<AuthorInterface>
{
public void setCode(int code);
public int getCode();
public void setName(String name);
public String getName();
public void setCity(String city);
public String getCity();
}