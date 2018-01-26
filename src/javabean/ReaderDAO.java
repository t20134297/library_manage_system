package javabean;
import java.sql.*;
import java.util.ArrayList;
public class ReaderDAO
{
	private Connection cn;
	public ReaderDAO(Connection cn)
	{
		this.cn = cn;
	}
	public void addReader(ReaderPO reader)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "insert into Reader(Rno,Rname,Rsex,Rage,Rdept,Rall,Rstyle)values(?,?,?,?,?,?,?)";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, reader.getRno());
				prepstmt.setString(2, reader.getRname());
				prepstmt.setString(3, reader.getRsex());
				prepstmt.setString(4,reader.getRage());
				prepstmt.setString(5, reader.getRdept());
				prepstmt.setInt(6, reader.getRall());
				prepstmt.setString(7, reader.getRstyle());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("addReader false     "+e);
		}
	}
	public void addReaders(ArrayList<ReaderPO> readers)
	{
		for(ReaderPO reader:readers)
			addReader(reader);
	}
	public void deleteReader(ReaderPO reader)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "delete from Reader where Rno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, reader.getRno());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("deleteReader false     "+e);
		}
	}
	public void deleteReaders(ArrayList<ReaderPO> readers)
	{
		for(ReaderPO reader:readers)
			deleteReader(reader);
	}
	public void updateReader(ReaderPO reader)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Reader set Rname=?,Rsex=?,Rage=?,Rdept=?,Rall=?,Rstyle=?"+
						" where Rno=?";
					PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
					prepstmt.setString(1,reader.getRname()); 
					prepstmt.setString(2,reader.getRsex()); 
					prepstmt.setString(3,reader.getRage()); 
					prepstmt.setString(4,reader.getRdept());
					prepstmt.setInt(5,reader.getRall());
					prepstmt.setString(6, reader.getRstyle());
					prepstmt.setString(7, reader.getRno());
					prepstmt.executeUpdate(); 
			}
		}
		catch(Exception e)
		{
			System.out.println("updateReader false     "+e);
		}
	}
	public void readerborrow(ReaderPO reader)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Reader set Rname=?,Rsex=?,Rage=?,Rdept=?,Rall=?,Rstyle=?"+
						" where Rno=?";
					PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
					int i = reader.getRall()+1;
					prepstmt.setString(1,reader.getRname()); 
					prepstmt.setString(2,reader.getRsex()); 
					prepstmt.setString(3,reader.getRage()); 
					prepstmt.setString(4,reader.getRdept());
					prepstmt.setInt(5,i);
					prepstmt.setString(6, reader.getRstyle());
					prepstmt.setString(7, reader.getRno());
					prepstmt.executeUpdate(); 
			}
		}
		catch(Exception e)
		{
			System.out.println("Readerborrow false     "+e);
		}
	}
	public void readerreturn(ReaderPO reader)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Reader set Rname=?,Rsex=?,Rage=?,Rdept=?,Rall=?,Rstyle=?"+
						" where Rno=?";
					PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
					int i = reader.getRall()-1;
					prepstmt.setString(1,reader.getRname()); 
					prepstmt.setString(2,reader.getRsex()); 
					prepstmt.setString(3,reader.getRage()); 
					prepstmt.setString(4,reader.getRdept());
					prepstmt.setInt(5,i);
					prepstmt.setString(6, reader.getRstyle());
					prepstmt.setString(7, reader.getRno());
					prepstmt.executeUpdate(); 
			}
		}
		catch(Exception e)
		{
			System.out.println("Readerborrow false     "+e);
		}
	}
	public void updateReaders(ArrayList<ReaderPO> readers)
	{
		for(ReaderPO reader:readers)
			updateReader(reader);
	}
	public Boolean queryhave(String Rno)
	{
		Boolean bool = false;
		ReaderPO reader = null;
		try
		{
			String sqlStr = "select * from Reader where Rno=?";
			PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
			prepstmt.setString(1, Rno);
			ResultSet rs = prepstmt.executeQuery();
			if(rs.next())
			{
				bool = true;
			}
		}
		catch(Exception e)
		{
			System.out.println("queryReaderByRno false     "+e);
		}
		return bool;
	}
	public ReaderPO queryReaderByRno(String Rno)
	{
		ReaderPO reader = null;
		try
		{
			String sqlStr = "select * from Reader where Rno=?";
			PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
			prepstmt.setString(1, Rno);
			ResultSet rs = prepstmt.executeQuery();
			if(rs.next())
			{
				reader = new ReaderPO();
				reader.setRno(rs.getString("Rno"));
				reader.setRname(rs.getString("Rname"));
				reader.setRsex(rs.getString("Rsex"));
				reader.setRage(rs.getString("Rage"));
				reader.setRdept(rs.getString("Rdept"));
				reader.setRall(rs.getInt("Rall"));
				reader.setRstyle(rs.getString("Rstyle"));
			}
		}
		catch(Exception e)
		{
			System.out.println("queryReaderByRno false     "+e);
		}
		return reader;
	}
	public ArrayList<ReaderPO> queryReaders()
	{
		ArrayList<ReaderPO> readers = new ArrayList<ReaderPO>() ;
		ReaderPO reader;
		try
		{
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from Reader order by Rno");
			while(rs.next())
			{
				reader = new ReaderPO();
				reader.setRno(rs.getString("Rno"));
				reader.setRname(rs.getString("Rname"));
				reader.setRsex(rs.getString("Rsex"));
				reader.setRage(rs.getString("Rage"));
				reader.setRdept(rs.getString("Rdept"));
				reader.setRall(rs.getInt("Rall"));
				reader.setRstyle(rs.getString("Rstyle"));
				readers.add(reader);
			}
		}
		catch(Exception e)
		{
			System.out.println("queryReaders false     "+e);
		}
		return readers;
	}
}
