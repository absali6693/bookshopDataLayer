import java.util.*;
import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorGetByCityTestCase
{
public static void main(String data[])
{
try
{
ArrayList<AuthorInterface> authors;
AuthorInterface authorInterface;
AuthorDAOInterface authorDAOInterface;
authorDAOInterface=new AuthorDAO();
authors=authorDAOInterface.getByCity(data[0]);
int x;
x=0;
while(x<authors.size())
{
authorInterface=authors.get(x);
System.out.println(authorInterface.getCode()+","+authorInterface.getName()+","+authorInterface.getCity());
x++;
}
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
