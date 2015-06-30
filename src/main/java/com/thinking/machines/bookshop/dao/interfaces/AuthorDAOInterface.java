package com.thinking.machines.bookshop.dao.interfaces;
import com.thinking.machines.bookshop.dao.exceptions.*;
import java.util.*;
public interface AuthorDAOInterface
{
public void add(AuthorInterface authorInterface) throws DAOException;
public void update(AuthorInterface authorInterface) throws DAOException;
public void remove(int code) throws DAOException;
public AuthorInterface get(int code) throws DAOException;
public AuthorInterface getByName(String name) throws DAOException;
public ArrayList<AuthorInterface> get() throws DAOException;
public ArrayList<AuthorInterface> getByCity(String city) throws DAOException;
public long getCount() throws DAOException;
public boolean exists(int code) throws DAOException;
public boolean existsByName(String name) throws DAOException;
public ArrayList<String> getCities() throws DAOException;
public ArrayList<AuthorInterface> getByRecordNumber(int fromRecordNumber,int uptoRecordNumber,String orderBy) throws DAOException;
}

