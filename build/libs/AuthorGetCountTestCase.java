import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorGetCountTestCase
{
public static void main(String data[])
{
try
{
AuthorDAOInterface authorDAOInterface;
authorDAOInterface=new AuthorDAO();
System.out.println(authorDAOInterface.getCount());
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
