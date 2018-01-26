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
		borrow.setbname("���ǳ�");
		borrow.setbookno("001");
		borrow.setbookname("��¥��");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		borrows.add(borrow);
		
		borrow = new BorrowPO();
		borrow.setbno("1002");
		borrow.setbname("֣����");
		borrow.setbookno("002");
		borrow.setbookname("��ƿ÷");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		borrows.add(borrow);
		
		borrow = new BorrowPO();
		borrow.setbno("1003");
		borrow.setbname("�����");
		borrow.setbookno("003");
		borrow.setbookname("�Զ�����ԭ��");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		borrows.add(borrow);
		
		dao.addBorrows(borrows);
		System.out.println("������������ʼ��¼");
		System.out.println("========������¼Ϊ==========");
		testqueryBorrows();
	}
	private void testqueryBorrows()
	{
		System.out.println("���ߺ�     ��������   ͼ����          ͼ����        ��������       ��������");
		ArrayList<BorrowPO> list = dao.queryBorrows();
		if(list != null && list.size()>0)
			for(BorrowPO one:list)
				System.out.println(one.toString());
	}
	private void testinsertRecort()
	{
		BorrowPO borrow = new BorrowPO();
		borrow.setbno("1004");
		borrow.setbname("�׺�Ⱥ");
		borrow.setbookno("004");
		borrow.setbookname("ս�����ƽ");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		dao.addBorrow(borrow);
		System.out.println();
		System.out.println("======����1004����б�========");
		testqueryBorrows();
	}
	private void testupdateBorrow()
	{
		BorrowPO borrow = dao.queryBorrowBybno("1001");
		borrow.setbname("��ʫ��");
		//borrow.setbookno("005");
		borrow.setbookname("���޴�½");
		borrow.setborrowdate("13.6.13");
		borrow.setreturndate("14.3.24");
		dao.updateBorrow(borrow);
		System.out.println();
		System.out.println("====����1001����б�====");
		testqueryBorrows();
	}
	private void testdeleteBorrow()
	{
		BorrowPO borrow = dao.queryBorrowBybno("1001");
		dao.deleteBorrow(borrow);
		System.out.println();
		System.out.println("=====ɾ��1001����б�=====");
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
