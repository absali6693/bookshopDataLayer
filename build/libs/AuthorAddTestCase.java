import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorAddTestCase
{
public static void main(String data[])
{
try
{
AuthorInterface authorInterface;
authorInterface=new Author();
authorInterface.setName(data[0]);
authorInterface.setCity(data[1]);
AuthorDAOInterface authorDAOInterface;
authorDAOInterface=new AuthorDAO();
authorDAOInterface.add(authorInterface);
System.out.println("Author added with code as : "+authorInterface.getCode());
}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
