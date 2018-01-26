package javabean;
import java.sql.*;
import java.util.ArrayList;

import javax.print.DocFlavor.READER;
public class ReaderDAOTest
{
	private DatabaseManager dbManager;
	private ReaderDAO dao;
	public ReaderDAOTest()
	{
		String jdbcDriver = "com.mysql.jdbc.Driver";;
		String dbUrl = "jdbc:mysql://localhost:3306/JavaLibrary";
		String dbUser = "root";
		String dbPassword ="manager";
		dbManager = new DatabaseManager(jdbcDriver,dbUrl,dbUser,dbPassword);
		dao = new ReaderDAO(dbManager.getConnection());
	}
	public void closeConnection()
	{
		dbManager.clodseConnection();
	}
	private void dropTable()
	{
		try
		{
		Statement stmt = dbManager.getConnection().createStatement();
		stmt.execute("drop table Reader");
		System.out.println("dropTable successfully");
		}
		catch(Exception e)
		{
			System.out.println("dropTable false     "+e);
		}
	}
	private void createTable()
	{
		try
		{
			Statement stmt = dbManager.getConnection().createStatement();
			stmt.execute("create table Reader(Rno varchar(20) primary key,Rstyle varchar(12),Rname varchar(12) ,Rsex varchar(12),Rage varchar(12),Rdept varchar(12),Rall int)");
			System.out.println("create table reader successfully");
		}
		catch(Exception e)
		{
			System.out.println("createTable false      "+e);
		}
	}
	private void insertInitRecoeds()
	{
		ArrayList<ReaderPO> readers = new ArrayList<ReaderPO>();
		ReaderPO reader = new ReaderPO() ;
		reader.setRno("20130001");
		reader.setRname("汤春仁");
		reader.setRsex("男");
		reader.setRage("20");
		reader.setRdept("信息");
		reader.setRall(2);
		reader.setRstyle("student");
		readers.add(reader);
		
		reader = new ReaderPO();
		reader.setRno("20130002");
		reader.setRname("则君");
		reader.setRsex("男");
		reader.setRage("20");
		reader.setRdept("建筑");
		reader.setRall(2);
		reader.setRstyle("teacher");
		readers.add(reader);
		
		reader = new ReaderPO();
		reader.setRno("20130003");
		reader.setRname("顾启凡");
		reader.setRsex("女");
		reader.setRage("22");
		reader.setRdept("机械");
		reader.setRall(2);
		reader.setRstyle("student");
		readers.add(reader);
		
		dao.addReaders(readers);
		
		System.out.println("初始化三个信息 ");
		System.out.println("-------三个信息为---------");
		testqueryReaders();
	}
	private void testqueryReaders()
	{
		System.out.println("读者号        "+"读者类型        "+"读者姓名        "+"读者性别          "+"读者年龄          "+"读者学院"+"       "+"借阅数量");
		ArrayList<ReaderPO> list = dao.queryReaders();
		if(list != null && list.size()>0)
		{
			for(ReaderPO one:list)
				System.out.println(one.toString());
		}
	}
	private void insertReadertest()
	{
		ReaderPO reader = new ReaderPO();
		reader.setRno("20130004");
		reader.setRname("李明泽");
		reader.setRsex("男");
		reader.setRage("18");
		reader.setRdept("电子");
		reader.setRall(2);
		reader.setRstyle("teacher");
		dao.addReader(reader);
		System.out.println();
		System.out.println("增加李明泽后的表格");
		testqueryReaders();
	}
	private void testupdateReader()
	{
		ReaderPO reader = dao.queryReaderByRno("20130001");
		reader.setRdept("国防");
		reader.setRage("12");
		reader.setRname("汤春仁");
		reader.setRsex("男");
		reader.setRall(2);
		reader.setRstyle("fffff");
		dao.updateReader(reader); 
		
		System.out.println();
		System.out.println("更改20130001后的表格");
		testqueryReaders();
	}
	private void testdeleteReader()
	{
		ReaderPO reader = dao.queryReaderByRno("20130004");
		dao.deleteReader(reader);
		System.out.println();
		System.out.println("删除20130004后的列表");
		testqueryReaders();
	}
	private void testreaderborrow()
	{
		ReaderPO reader = dao.queryReaderByRno("20130001");
		dao.readerborrow(reader);
		System.out.println();
		System.out.println("20130001借阅后的列表");
		testqueryReaders();
	}
	private void testreaderreturn()
	{
		ReaderPO reader = dao.queryReaderByRno("20130002");
		dao.readerreturn(reader);
		System.out.println();
		System.out.println("20130002归还后的列表");
		testqueryReaders();
	}
	private void testqueryhave()
	{
		System.out.println("查找是否有20130004");
		System.out.println(dao.queryhave("20130004"));
	}
	public static void main(String[] args)
	{
		ReaderDAOTest rdt = new ReaderDAOTest();
		rdt.dropTable();
		rdt.createTable();
		rdt.insertInitRecoeds();
		rdt.insertReadertest();
		rdt.testupdateReader();
		rdt.testdeleteReader();
		rdt.testreaderborrow();
		rdt.testreaderreturn();
		rdt.testqueryhave();
	}
}