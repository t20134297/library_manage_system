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
			System.out.println("数据库驱动加载成功");
		}
		catch(Exception e)
		{
			System.out.println("数据库驱动加载失败         "+e);
		}
		try
		{
			cn = DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			System.out.println("数据库连接成功      ");
		}
		catch(Exception e)
		{
			System.out.println("数据库连接失败      "+e);
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
