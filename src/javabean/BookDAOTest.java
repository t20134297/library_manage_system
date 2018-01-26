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
	    book.setBname("白鹿原");
	    book.setBwriter("陈忠实");
	    book.setBtopic("文学");
	    book.setBall(5);
	    book.setBnow(5);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("002");
	    book.setBname("白鹿原");
	    book.setBwriter("都梁");
	    book.setBtopic("文学");
	    book.setBall(4);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("003");
	    book.setBname("悟空传");
	    book.setBwriter("唐僧");
	    book.setBtopic("故事");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("004");
	    book.setBname("西游记");
	    book.setBwriter("唐僧");
	    book.setBtopic("故事");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("005");
	    book.setBname("水浒传");
	    book.setBwriter("施耐庵");
	    book.setBtopic("故事");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    book = new BookPO();
	    book.setBno("006");
	    book.setBname("大闹天空");
	    book.setBwriter("孙悟空");
	    book.setBtopic("故事");
	    book.setBall(5);
	    book.setBnow(4);
	    books.add(book);
	    
	    dao.addBooks(books);
	    
	    System.out.println("insert 5 records");
	    System.out.println("------------列出三个记录--------");
	    testqueryBooks();
	}
	private void testqueryBooks()
	{
		System.out.println("编号      "+"题目           "+" 作者            "+"主题                  "+"总共             "+"借出");
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
		book.setBname("电路原理");
		book.setBwriter("李华");
		book.setBtopic("自动化");
		book.setBall(5);
		book.setBnow(5);
		dao.addBook(book);
		System.out.println();
		System.out.println("添加电路原理后的");
		testqueryBooks();
	}
	private void testupdateBook()
	{
		BookPO book = dao.queryBookByBno("006");
		book.setBname("高数");
		book.setBwriter("宋叔尼");
		book.setBtopic("理科");
		book.setBall(5);
		book.setBnow(2);
		dao.updateBook(book);
		System.out.println();
		System.out.println("更改006后的目录");
		testqueryBooks();
	}
	private void tesdeleteBook()
	{
		BookPO book = dao.queryBookByBno("006");
		dao.deleteBook(book);
		System.out.println();
		System.out.println("删除006后的列表");
		testqueryBooks();
	}
	private void testbookless()
	{
		BookPO book = dao.queryBookByBno("001");
		dao.Bookless(book);
		System.out.println("借出一本001后");
		testqueryBooks();
	}
	private void testbookmore()
	{
		BookPO book = dao.queryBookByBno("007");
		dao.Bookmore(book);
		System.out.println("归007");
		testqueryBooks();
	}
	private void testqueryByname()
	{
		System.out.println("查找书名为白鹿原的");
		System.out.println("编号      "+"题目           "+" 作者            "+"主题                  "+"总共             "+"借出");
		ArrayList<BookPO> list = dao.queryBookByBname("白鹿原");
		if(list != null && list.size()>0)
		{
			for(BookPO one:list)
				System.out.println(one.toString());
		}
	}
	private void testqueryByBwriter()
	{
		System.out.println("查找作者为唐僧的");
		System.out.println("编号      "+"题目           "+" 作者            "+"主题                  "+"总共             "+"借出");
		ArrayList<BookPO> list = dao.queryBookByBwriter("唐僧");
		if(list != null && list.size()>0)
		{
			for(BookPO one:list)
				System.out.println(one.toString());
		}
	}
	private void testqueryByBtopic()
	{
		System.out.println("查找主题为故事的");
		System.out.println("编号      "+"题目           "+" 作者            "+"主题                  "+"总共             "+"借出");
		ArrayList<BookPO> list = dao.queryBookByBtopic("故事");
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
