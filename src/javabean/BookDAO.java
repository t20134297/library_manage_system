package javabean;
import java.sql.*;
import java.util.ArrayList;

public class BookDAO 
{
	private Connection cn;
	public BookDAO(Connection cn)
	{
		this.cn = cn;
	}
	public void addBook(BookPO book)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "insert into Book(Bno,Bname,Bwriter,Btopic,Ball,Bnow)values(?,?,?,?,?,?)";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, book.getBno());
				prepstmt.setString(2, book.getBname());
				prepstmt.setString(3, book.getBwriter());
				prepstmt.setString(4, book.getBtopic());
				prepstmt.setInt(5, book.getBall());
				prepstmt.setInt(6, book.getBnow());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("addBook false      "+e);
		}
	}
	public void addBooks(ArrayList<BookPO> books)
	{
		for(BookPO book:books)
			addBook(book);
	}
	public void deleteBook(BookPO book)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "delete from Book where Bno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, book.getBno());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("deleteBook false      "+e);
		}
	}
	public void deleteBooks(ArrayList<BookPO> books)
	{
		for(BookPO book:books)
			deleteBook(book);
	}
	public void updateBook(BookPO book)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Book set Bname=?,Bwriter=?,Btopic=?,Ball=?,Bnow=?"+
						" where Bno=?";
					PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
					prepstmt.setString(1,book.getBname()); 
					prepstmt.setString(2,book.getBwriter()); 
					prepstmt.setString(3,book.getBtopic()); 
					prepstmt.setInt(4,book.getBall());
					prepstmt.setInt(5,book.getBnow());
					prepstmt.setString(6, book.getBno());
					prepstmt.executeUpdate(); 
			}
		}
		catch(Exception e)
		{
			System.out.println("updateBook false      "+e);
		}
	}
	public void Bookless(BookPO book)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Book set Bname=?,Bwriter=?,Btopic=?,Ball=?,Bnow=?"+
						" where Bno=?";
					PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
					prepstmt.setString(1,book.getBname()); 
					prepstmt.setString(2,book.getBwriter()); 
					prepstmt.setString(3,book.getBtopic()); 
					prepstmt.setInt(4,book.getBall());
					prepstmt.setInt(5,book.getBnow()+1);
					prepstmt.setString(6, book.getBno());
					prepstmt.executeUpdate(); 
			}
		}
		catch(Exception e)
		{
			System.out.println("updateBook false      "+e);
		}
	}
	public void Bookmore(BookPO book)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Book set Bname=?,Bwriter=?,Btopic=?,Ball=?,Bnow=?"+
						" where Bno=?";
					PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
					prepstmt.setString(1,book.getBname()); 
					prepstmt.setString(2,book.getBwriter()); 
					prepstmt.setString(3,book.getBtopic()); 
					prepstmt.setInt(4,book.getBall());
					prepstmt.setInt(5,book.getBnow()-1);
					prepstmt.setString(6, book.getBno());
					prepstmt.executeUpdate(); 
			}
		}
		catch(Exception e)
		{
			System.out.println("updateBook false      "+e);
		}
	}				
	public void updateBooks(ArrayList<BookPO> books)
	{
		for(BookPO book:books)
			updateBook(book);
	}
	public BookPO queryBookByBno(String Bno)
	{
		BookPO book = null;
		try
		{
			if(cn != null)
			{
				String sqlStr = "select * from Book where Bno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1,Bno);
				ResultSet rs = prepstmt.executeQuery();
				if(rs.next())
				{
					book = new BookPO();
					book.setBno(rs.getString("Bno"));
					book.setBname(rs.getString("Bname"));
					book.setBwriter(rs.getString("Bwriter"));
					book.setBtopic(rs.getString("Btopic"));
					book.setBall(rs.getInt("Ball"));
					book.setBnow(rs.getInt("Bnow"));
					
				}
				else
				{
					System.out.println("不存在编号为  "+Bno+"  的书");
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryBook false      "+e);
		}
		return book;
	}
	public ArrayList<BookPO> queryBooks()
	{
		ArrayList<BookPO> books = new ArrayList<BookPO>();
		BookPO book;
		try
		{
			if(cn != null)
			{
				Statement stmt = cn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Book order by Bno");
				while(rs.next())
				{
					book = new BookPO();
					book.setBno(rs.getString("Bno"));
					book.setBname(rs.getString("Bname"));
					book.setBwriter(rs.getString("Bwriter"));
					book.setBtopic(rs.getString("Btopic"));
					book.setBall(rs.getInt("Ball"));
					book.setBnow(rs.getInt("Bnow"));
					books.add(book);
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryBooks false     "+e);
		}
		return books;
	}
	public Boolean queryBookhave(String Bno)
	{
		Boolean bool = false;
		BookPO book = null;
		try
		{
			if(cn != null)
			{
				String sqlStr = "select * from Book where Bno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1,Bno);
				ResultSet rs = prepstmt.executeQuery();
				if(rs.next())
				{
					bool = true;					
				}
				else
				{
					System.out.println("不存在编号为  "+Bno+"  的书");
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryBook false      "+e);
		}
		return bool;
	}
	public ArrayList<BookPO> queryBookByBname(String Bname)
	{
		ArrayList<BookPO> books = new ArrayList<BookPO>();
		BookPO book;
		try
		{
			if(cn != null)
			{
				String sqlStr = "select * from Book where Bname=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1,Bname);
				ResultSet rs = prepstmt.executeQuery();
				while(rs.next())
				{
					book = new BookPO();
					book.setBno(rs.getString("Bno"));
					book.setBname(rs.getString("Bname"));
					book.setBwriter(rs.getString("Bwriter"));
					book.setBtopic(rs.getString("Btopic"));
					book.setBall(rs.getInt("Ball"));
					book.setBnow(rs.getInt("Bnow"));
					books.add(book);
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryBookByname false     "+e);
		}
		return books;
	}
	public ArrayList<BookPO> queryBookByBwriter(String Bwriter)
	{
		ArrayList<BookPO> books = new ArrayList<BookPO>();
		BookPO book;
		try
		{
			if(cn != null)
			{
				String sqlStr = "select * from Book where Bwriter=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1,Bwriter);
				ResultSet rs = prepstmt.executeQuery();
				while(rs.next())
				{
					book = new BookPO();
					book.setBno(rs.getString("Bno"));
					book.setBname(rs.getString("Bname"));
					book.setBwriter(rs.getString("Bwriter"));
					book.setBtopic(rs.getString("Btopic"));
					book.setBall(rs.getInt("Ball"));
					book.setBnow(rs.getInt("Bnow"));
					books.add(book);
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryBookByBwriter false     "+e);
		}
		return books;
	}
	public ArrayList<BookPO> queryBookByBtopic(String Btopic)
	{
		ArrayList<BookPO> books = new ArrayList<BookPO>();
		BookPO book;
		try
		{
			if(cn != null)
			{
				String sqlStr = "select * from Book where Btopic=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1,Btopic);
				ResultSet rs = prepstmt.executeQuery();
				while(rs.next())
				{
					book = new BookPO();
					book.setBno(rs.getString("Bno"));
					book.setBname(rs.getString("Bname"));
					book.setBwriter(rs.getString("Bwriter"));
					book.setBtopic(rs.getString("Btopic"));
					book.setBall(rs.getInt("Ball"));
					book.setBnow(rs.getInt("Bnow"));
					books.add(book);
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryBookByBtopic false     "+e);
		}
		return books;
	}
	}