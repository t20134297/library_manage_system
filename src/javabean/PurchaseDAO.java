package javabean;
import java.sql.*;
import java.util.ArrayList;
public class PurchaseDAO 
{
	private Connection cn;
	public PurchaseDAO(Connection cn)
	{
		this.cn = cn;
	}
	public void addPurchase(PurchasePO pur)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "insert into Purchase(Pno,Pname,Pwriter,Ptopic,Pall,Pchange,Pnow)values(?,?,?,?,?,?,?)";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, pur.getPno());
				prepstmt.setString(2, pur.getPname());
				prepstmt.setString(3, pur.getPwriter());
				prepstmt.setString(4, pur.getPtopic());
				prepstmt.setInt(5, pur.getPall());
				prepstmt.setString(6, pur.getPchange());
				prepstmt.setInt(7, pur.getPnow());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("addPurchase false      "+e);
		}
	}
	public void addPurchases(ArrayList<PurchasePO> purs)
	{
		for(PurchasePO pur:purs)
			addPurchase(pur);
	}
	public void deletePurchase(PurchasePO pur)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "delete from Purchase where Pno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1, pur.getPno());
				prepstmt.executeUpdate();
			}
		}
		catch(Exception e)
		{
			System.out.println("deletePurchase false      "+e);
		}
	}
	public void deletePurchase(ArrayList<PurchasePO> purs)
	{
		for(PurchasePO pur:purs)
			deletePurchase(pur);
	}
	public void updatePurchase(PurchasePO pur)
	{
		try
		{
			if(cn != null)
			{
				String sqlStr = "update Purchase set Pname=?,Pwriter=?,Ptopic=?,Pall=?,Pchange=?,Pnow=?"+
						" where Pno=?";
					PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
					prepstmt.setString(1,pur.getPname()); 
					prepstmt.setString(2,pur.getPwriter()); 
					prepstmt.setString(3,pur.getPtopic()); 
					prepstmt.setInt(4,pur.getPall());
					prepstmt.setString(5,pur.getPchange());
					prepstmt.setInt(6,pur.getPall());
					prepstmt.setString(7,pur.getPno());
					prepstmt.executeUpdate(); 
			}
		}
		catch(Exception e)
		{
			System.out.println("updatePurchase false      "+e);
		}
	}
	public void updatePurchases(ArrayList<PurchasePO> purs)
	{
		for(PurchasePO pur:purs)
			updatePurchase(pur);
	}
	public PurchasePO queryPurchaseByPno(String Pno)
	{
		PurchasePO pur = null;
		try
		{
			if(cn != null)
			{
				String sqlStr = "select * from Purchase where Pno=?";
				PreparedStatement prepstmt = cn.prepareStatement(sqlStr);
				prepstmt.setString(1,Pno);
				ResultSet rs = prepstmt.executeQuery();
				if(rs.next())
				{
					pur = new PurchasePO();
					pur.setPno(rs.getString("Pno"));
					pur.setPname(rs.getString("Pname"));
					pur.setPwriter(rs.getString("Pwriter"));
					pur.setPtopic(rs.getString("Ptopic"));
					pur.setPall(rs.getInt("Pall"));
					pur.setPchange(rs.getString("Pchange"));
					pur.setPnow(rs.getInt("Pnow"));
				}
				else
				{
					System.out.println("不存在编号为  "+Pno+"  的书");
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryPurchase false      "+e);
		}
		return pur;
	}
	public ArrayList<PurchasePO> queryPurchases()
	{
		ArrayList<PurchasePO> purs = new ArrayList<PurchasePO>();
		PurchasePO pur;
		try
		{
			if(cn != null)
			{
				Statement stmt = cn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from Purchase order by Pno");
				while(rs.next())
				{
					pur = new PurchasePO();
					pur.setPno(rs.getString("Pno"));
					pur.setPname(rs.getString("Pname"));
					pur.setPwriter(rs.getString("Pwriter"));
					pur.setPtopic(rs.getString("Ptopic"));
					pur.setPall(rs.getInt("Pall"));
					pur.setPchange(rs.getString("Pchange"));
					pur.setPnow(rs.getInt("Pnow"));
					purs.add(pur);
				}
			}
			}
		catch(Exception e)
		{
			System.out.println("queryPurchases false     "+e);
		}
		return purs;
	}
}
