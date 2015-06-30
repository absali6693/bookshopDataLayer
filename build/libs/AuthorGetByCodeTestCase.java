import com.thinking.machines.bookshop.dao.*;
import com.thinking.machines.bookshop.dao.interfaces.*;
import com.thinking.machines.bookshop.dao.exceptions.*;
public class AuthorGetByCodeTestCase
{
public static void main(String data[])
{
try
{
AuthorInterface authorInterface;
AuthorDAOInterface authorDAOInterface;
authorDAOInterface=new AuthorDAO();
authorInterface=authorDAOInterface.get(Integer.parseInt(data[0]));
System.out.println("Code : "+authorInterface.getCode());
System.out.println("Name : "+authorInterface.getName());
System.out.println("City : "+authorInterface.getCity());


}catch(DAOException daoException)
{
System.out.println(daoException);
}
}
}
