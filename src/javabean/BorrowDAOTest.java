package javabean;
import java.sql.*;
import java.util.ArrayList;
public class BorrowDAOTest 
{
	private DatabaseManager dbManager;
	private BorrowDAO dao;
	public BorrowDAOTest()
	{
		String jdbcDriver ="com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/JavaLibrary";
		String dbUser = "root";
		String dbPassword = "manager";
		dbManager = new DatabaseManager(jdbcDriver,dbUrl,dbUser,dbPassword);
		dao = new BorrowDAO(dbManager.getConnection());
	}
	private void dropTable()
	{
		try
		{
			Statement stmt = dbManager.getConnection().createStatement();
			stmt.execute("drop table Borrow");
			System.out.println("drop table Borrow successfully");
		}
		catch(Exception e)
		{
			System.out.println("drop table Borrow false     "+e);
		}
	}
	private void createTable()
	{
		try
		{
			Statement stmt = dbManager.getConnection().createStatement();
			stmt.execute("create table Borrow (bno varchar(12),bname varchar(12),bookno varchar(20),bookname varchar(20),borrowdate varchar(30),returndate varchar(30), primary key(bno,bookno))");
			System.out.println("create table Borrow successfully");
		}
		catch(Exception e)
		{
			System.out.println("create table Borrow false     "+e);
		}
	}
	private void insertInitRecords()
	{
		ArrayList<BorrowPO> borrows = new ArrayList<BorrowPO>();
		BorrowPO borrow = new BorrowPO();
		borrow.setbno("1001");
		borrow.setbname("郎星辰");
		borrow.setbookno("001");
		borrow.setbookname("红楼梦");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		borrows.add(borrow);
		
		borrow = new BorrowPO();
		borrow.setbno("1002");
		borrow.setbname("郑永明");
		borrow.setbookno("002");
		borrow.setbookname("金瓶梅");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		borrows.add(borrow);
		
		borrow = new BorrowPO();
		borrow.setbno("1003");
		borrow.setbname("董泽洪");
		borrow.setbookno("003");
		borrow.setbookname("自动控制原理");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		borrows.add(borrow);
		
		dao.addBorrows(borrows);
		System.out.println("输入了三个初始记录");
		System.out.println("========三个记录为==========");
		testqueryBorrows();
	}
	private void testqueryBorrows()
	{
		System.out.println("读者号     读者姓名   图书编号          图书名        借阅日期       还书日期");
		ArrayList<BorrowPO> list = dao.queryBorrows();
		if(list != null && list.size()>0)
			for(BorrowPO one:list)
				System.out.println(one.toString());
	}
	private void testinsertRecort()
	{
		BorrowPO borrow = new BorrowPO();
		borrow.setbno("1004");
		borrow.setbname("白鹤群");
		borrow.setbookno("004");
		borrow.setbookname("战争与和平");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		dao.addBorrow(borrow);
		System.out.println();
		System.out.println("======增加1004后的列表========");
		testqueryBorrows();
	}
	private void testupdateBorrow()
	{
		BorrowPO borrow = dao.queryBorrowBybno("1001");
		borrow.setbname("崔诗广");
		//borrow.setbookno("005");
		borrow.setbookname("斗罗大陆");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		dao.updateBorrow(borrow);
		System.out.println();
		System.out.println("====更改1001后的列表====");
		testqueryBorrows();
	}
	private void testdeleteBorrow()
	{
		BorrowPO borrow = dao.queryBorrowBybno("1001");
		dao.deleteBorrow(borrow);
		System.out.println();
		System.out.println("=====删除1001后的列表=====");
		testqueryBorrows();
	}
	private void testquerybibnoandbookno()
	{
		Boolean boolea =  dao.queryBorrowBybnoandbookno("1002","002");
		System.out.println();
		System.out.println(boolea);
	}
	
	public static void main(String[] args)
	{
		BorrowDAOTest bdt = new BorrowDAOTest();
		bdt.dropTable();
		bdt.createTable();
		bdt.insertInitRecords();
		bdt.testinsertRecort();
		bdt.testupdateBorrow();
		bdt.testdeleteBorrow();
		bdt.testquerybibnoandbookno();
	}
}
