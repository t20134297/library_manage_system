package javabean;

import java.sql.*;
import java.util.ArrayList;

public class BookDAOTest 
{
	private DatabaseManager dbManager;
	private BookDAO dao;
	public BookDAOTest()
	{
		String jdbcDriver = "com.mysql.jdbc.Driver";
		String dbUrl = "jdbc:mysql://localhost:3306/JavaLibrary";
		String dbUser = "root";
		String dbPassword = "manager";
		dbManager = new DatabaseManager(jdbcDriver,dbUrl,dbUser,dbPassword);
		dao = new BookDAO(dbManager.getConnection());
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
			stmt.execute("drop table Book");
			System.out.println("drop table Book succeful");
		}
		catch(Exception e)
		{
			System.out.println("dropTable false     "+e);
		}
	}
	private void createTable()
	{
		try{
			Statement stmt= dbManager.getConnection().createStatement();		
			stmt.execute("create table Book (Bno varchar(12)primary key ,Bname varchar(12),Bwriter varchar(12),Btopic varchar(12),Ball int,Bnow int)");
			System.out.println("Created table Book");
		}catch(Exception e){
			System.out.println("Created table Book error:"+e);
		}		
	}
	private void insertInitRecords()
	{
		ArrayList<BookPO> books = new ArrayList<BookPO>();
		BookPO book = new BookPO();
	    book.setBno("001");
	    book.setBname("��¹ԭ");
	    book.setBwriter("����ʵ");
	    book.setBtopic("��ѧ");
	    book.setBall(5);
	    book.setBnow(5);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("002");
	    book.setBname("��¹ԭ");
	    book.setBwriter("����");
	    book.setBtopic("��ѧ");
	    book.setBall(4);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("003");
	    book.setBname("��մ�");
	    book.setBwriter("��ɮ");
	    book.setBtopic("����");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("004");
	    book.setBname("���μ�");
	    book.setBwriter("��ɮ");
	    book.setBtopic("����");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("005");
	    book.setBname("ˮ䰴�");
	    book.setBwriter("ʩ����");
	    book.setBtopic("����");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("006");
	    book.setBname("�������");
	    book.setBwriter("�����");
	    book.setBtopic("����");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    dao.addBooks(books);
	    
	    System.out.println("insert 5 records");
	    System.out.println("------------�г�������¼--------");
	    testqueryBooks();
	}
	private void testqueryBooks()
	{
		System.out.println("���      "+"��Ŀ           "+" ����            "+"����                  "+"�ܹ�             "+"���");
		ArrayList<BookPO> list = dao.queryBooks();
		if(list != null && list.size()>0)
		{
			for(BookPO one:list)
				System.out.println(one.toString());
		}
	}
	private void testinsertRecord()
	{
		BookPO book = new BookPO();
		book.setBno("007");
		book.setBname("��·ԭ��");
		book.setBwriter("�");
		book.setBtopic("�Զ���");
		book.setBall(5);
		book.setBnow(5);
		dao.addBook(book);
		System.out.println();
		System.out.println("��ӵ�·ԭ����");
		testqueryBooks();
	}
	private void testupdateBook()
	{
		BookPO book = dao.queryBookByBno("006");
		book.setBname("����");
		book.setBwriter("������");
		book.setBtopic("���");
		book.setBall(5);
		book.setBnow(2);
		dao.updateBook(book);
		System.out.println();
		System.out.println("����006���Ŀ¼");
		testqueryBooks();
	}
	private void tesdeleteBook()
	{
		BookPO book = dao.queryBookByBno("006");
		dao.deleteBook(book);
		System.out.println();
		System.out.println("ɾ��006����б�");
		testqueryBooks();
	}
	private void testbookless()
	{
		BookPO book = dao.queryBookByBno("001");
		dao.Bookless(book);
		System.out.println("���һ��001��");
		testqueryBooks();
	}
	private void testbookmore()
	{
		BookPO book = dao.queryBookByBno("007");
		dao.Bookmore(book);
		System.out.println("��007");
		testqueryBooks();
	}
	private void testqueryByname()
	{
		System.out.println("��������Ϊ��¹ԭ��");
		System.out.println("���      "+"��Ŀ           "+" ����            "+"����                  "+"�ܹ�             "+"���");
		ArrayList<BookPO> list = dao.queryBookByBname("��¹ԭ");
		if(list != null && list.size()>0)
		{
			for(BookPO one:list)
				System.out.println(one.toString());
		}
	}
	private void testqueryByBwriter()
	{
		System.out.println("��������Ϊ��ɮ��");
		System.out.println("���      "+"��Ŀ           "+" ����            "+"����                  "+"�ܹ�             "+"���");
		ArrayList<BookPO> list = dao.queryBookByBwriter("��ɮ");
		if(list != null && list.size()>0)
		{
			for(BookPO one:list)
				System.out.println(one.toString());
		}
	}
	private void testqueryByBtopic()
	{
		System.out.println("��������Ϊ���µ�");
		System.out.println("���      "+"��Ŀ           "+" ����            "+"����                  "+"�ܹ�             "+"���");
		ArrayList<BookPO> list = dao.queryBookByBtopic("����");
		if(list != null && list.size()>0)
		{
			for(BookPO one:list)
				System.out.println(one.toString());
		}
	}
	private void testhave()
	{
		System.out.println(dao.queryBookhave("00x2"));
	}
	public static void main(String[] args)
	{
		BookDAOTest bdt = new BookDAOTest();
		bdt.dropTable();
		bdt.createTable();
		bdt.insertInitRecords();
		bdt.testinsertRecord();
		bdt.testupdateBook();
		bdt.tesdeleteBook();
		bdt.testbookless();
		bdt.testbookmore();
		bdt.testqueryByname();
		bdt.testqueryByBwriter();
		bdt.testqueryByBtopic();
		bdt.testhave(); 
	}
}
