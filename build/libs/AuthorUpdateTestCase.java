import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorUpdateTestCase
{
public static void main(String data[])
{
try
{
AuthorInterface authorInterface;
authorInterface=new Author();
authorInterface.setCode(Integer.parseInt(data[0]));
authorInterface.setName(data[1]);
authorInterface.setCity(data[2]);
AuthorDAOInterface authorDAOInterface;
authorDAOInterface=new AuthorDAO();
authorDAOInterface.update(authorInterface);
System.out.println("Author updated");
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
