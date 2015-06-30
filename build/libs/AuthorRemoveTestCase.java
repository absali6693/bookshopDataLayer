import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorRemoveTestCase
{
public static void main(String data[])
{
try
{
AuthorDAOInterface authorDAOInterface;
authorDAOInterface=new AuthorDAO();
authorDAOInterface.remove(Integer.parseInt(data[0]));
System.out.println("Author removed");
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
