package javabean;
import java.sql.*;
import java.util.ArrayList;
public class BorrowDAO 
{
	private Connection cn;
	public BorrowDAO(Connection cn)
	{
		this.cn = cn;
	}
	public void closeConnection()
	{
		try
		{
			cn.close();
		}
		catch(Exception e)
		{
			System.out.println("closeConnection false     "+e);
		}
	}
	public void addBorrow(BorrowPO borrow)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "insert into Borrow (bno,bname,bookno,bookname,borrowdate,returndate)values(?,?,?,?,?,?)";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, borrow.getbno());
				prepstmt.setString(2,borrow.getbname());
				prepstmt.setString(3, borrow.getbookno());
				prepstmt.setString(4,borrow.getbookname());
				prepstmt.setString(5,borrow.getborrowdate());
				prepstmt.setString(6,borrow.getreturndate());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("addBorrow false     "+e);
		}
	}
	public void addBorrows(ArrayList<BorrowPO> borrows)
	{
		for(BorrowPO borrow:borrows)
			addBorrow(borrow);
	}
	public void deleteBorrow(BorrowPO borrow)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "delete from Borrow where bno=? and bookno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, borrow.getbno());
				prepstmt.setString(2, borrow.getbookno());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("deleteBorrow false     "+e);
		}
	}
	public void deleteBorrows(ArrayList<BorrowPO> borrows)
	{
		for(BorrowPO borrow:borrows)
			deleteBorrow(borrow);
	}
	public void updateBorrow(BorrowPO borrow)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Borrow set bname=?,bookname=?,borrowdate=?,returndate=? where bno=?and bookno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, borrow.getbname());
				prepstmt.setString(2, borrow.getbookname());
				prepstmt.setString(3, borrow.getborrowdate());
				prepstmt.setString(4, borrow.getreturndate());
				prepstmt.setString(5, borrow.getbno());
				prepstmt.setString(6, borrow.getbookno());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("updateBorrow false      "+e);
		}
	}
	public void updateBorrows(ArrayList<BorrowPO> borrows)
	{
		for(BorrowPO borrow:borrows)
			updateBorrow(borrow);
	}
	public BorrowPO queryBorrowBybno(String bno)
	{
		BorrowPO borrow = new BorrowPO();
		try
		{
			String sqlStr = "select * from Borrow where bno=?";
			PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
			prepstmt.setString(1, bno);
			ResultSet rs = prepstmt.executeQuery();
			if(rs.next())
			{
				borrow.setbno(rs.getString("bno"));
				borrow.setbname(rs.getString("bname"));
				borrow.setbookno(rs.getString("bookno"));
				borrow.setbookname(rs.getString("bookname"));
				borrow.setborrowdate(rs.getString("borrowdate"));
				borrow.setreturndate(rs.getString("returndate"));
			}
		}
		catch(Exception e)
		{
			System.out.println("queryBorrowBybno false     "+e);
		}
		return borrow;
	}
	public Boolean queryBorrowBybnoandbookno(String bno,String bookno)
	{
		BorrowPO borrow = new BorrowPO();
		Boolean boolea = true;
		try
		{
			String sqlStr = "select * from Borrow where bno=? and bookno=?";
			PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
			prepstmt.setString(1, bno);
			prepstmt.setString(2, bookno);
			ResultSet rs = prepstmt.executeQuery();
			if(rs.next())
			{
				boolea=true;
			}
			else 
				boolea =  false;
		}
		catch(Exception e)
		{
			System.out.println("queryBorrowBybno false     "+e);
		}
		return boolea;
	}
	public ArrayList<BorrowPO> queryBorrows()
	{
		ArrayList<BorrowPO> borrows = new ArrayList<BorrowPO>();
		BorrowPO borrow;
		try
		{
			if(cn != null)
			{
				Statement stmt = cn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Borrow order by bno");
				while(rs.next())
				{
					borrow = new BorrowPO();
					borrow.setbno(rs.getString("bno"));
					borrow.setbname(rs.getString("bname"));
					borrow.setbookno(rs.getString("bookno"));
					borrow.setbookname(rs.getString("bookname"));
					borrow.setborrowdate(rs.getString("borrowdate"));
					borrow.setreturndate(rs.getString("returndate"));
					borrows.add(borrow);
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("queryBorrows false     "+e);
		}
		return borrows;
	}
}
