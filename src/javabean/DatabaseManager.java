package javabean;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseManager 
{
	private Connection cn;
	public DatabaseManager(String jdbcDriver,String dbUrl,String dbUser,String dbPassword)
	{
		try
		{
			Class.forName(jdbcDriver).newInstance();
			System.out.println("���ݿ��������سɹ�");
		}
		catch(Exception e)
		{
			System.out.println("���ݿ���������ʧ��         "+e);
		}
		try
		{
			cn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			System.out.println("���ݿ����ӳɹ�      ");
		}
		catch(Exception e)
		{
			System.out.println("���ݿ�����ʧ��      "+e);
		}
	}
	public Connection getConnection()
	{
		return cn;
	}
	public void clodseConnection()
	{
		try
		{
		cn.close();
		}
		catch(Exception e)
		{
			System.out.println("closeConnection false      "+e);
		}
	}
}
