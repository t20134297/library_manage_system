package controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javabean.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PurchaseAction implements IAction 
{
	public String execute(HttpServletRequest request,Connection cn)
	{
		PurchaseDAO purchasedao = new PurchaseDAO(cn);
		BookDAO bookdao = new BookDAO(cn);
		String operation = request.getParameter("operation");
		if( operation.equals("update"))
		{
			BookPO book = new BookPO();
			String bno = request.getParameter("no");
			book.setBno(bno);
			String bname = request.getParameter("name");
			book.setBname(bname);
			String bwriter = request.getParameter("writer");
			book.setBwriter(bwriter);
			String btopic = request.getParameter("topic");
			book.setBtopic(btopic);
			String ball = request.getParameter("all");
			int all = Integer.parseInt(ball);
			book.setBall(all);
			String bnow = request.getParameter("now");
			int now = Integer.parseInt(bnow);
			book.setBnow(now);
			
			bookdao.updateBook(book); 
		}
		try
		{
			Statement stmt = cn.createStatement();
			stmt.execute("drop table Purchase");
		}
		catch (Exception e)
		{}
		try
		{
			Statement stmt= cn.createStatement();		
			stmt.execute("create table Purchase (Pno varchar(12)primary key ,Pname varchar(12),Pwriter varchar(12),Ptopic varchar(12),Pall int,Pnow int,Pchange varchar(12))");
		}
		catch(Exception e)
		{}		
		
		ArrayList<BookPO> books = bookdao.queryBooks();
		BookPO book;
		PurchasePO pur;
		for(int i=0;i<books.size();i++)
		{
			book = new BookPO();
			pur = new PurchasePO();
			book = books.get(i);
			pur.setPno(book.getBno());
			pur.setPname(book.getBname());
			pur.setPwriter(book.getBwriter());
			pur.setPall(book.getBall());
			pur.setPtopic(book.getBtopic());
			pur.setPnow(book.getBnow());
			if(book.getBall()<5)
				{
					pur.setPchange("可以");
				}
			else
				pur.setPchange("数量已满");
			
			purchasedao.addPurchase(pur);
		} 
		List<PurchasePO> purs = purchasedao.queryPurchases();
		HttpSession session = request.getSession(true);
		session.setAttribute("Purchaselist", purs);
		return "/Purchaselist.jsp";
	}
}
