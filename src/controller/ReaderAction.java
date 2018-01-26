package controller;

import java.util.List;
import java.sql.Connection;

import javabean.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ReaderAction implements IAction 
{
	public String execute(HttpServletRequest request,Connection cn)
	{
		ReaderDAO readerdao = new ReaderDAO(cn);
		String operation = request.getParameter("operation");
		String rno = request.getParameter("no");
		String rstyle = request.getParameter("style");
		String rname = request.getParameter("name");
		String rsex = request.getParameter("sex");
		String rage = request.getParameter("age");
		String rdept = request.getParameter("dept");
		String rall = request.getParameter("all");
		if(operation.equals("insert"))
		{
			if(readerdao.queryhave(rno))
				{
					return "/Readeraddagain.jsp";
				}
			ReaderPO reader0 = new ReaderPO();
			reader0.setRno(rno);
			reader0.setRstyle(rstyle);
			reader0.setRname(rname);
			reader0.setRsex(rsex);
			reader0.setRage(rage);
			reader0.setRdept(rdept);
			int all0 = Integer.parseInt(rall);
			readerdao.addReader(reader0); 
		}
		if( operation.equals("delete") || operation.equals("update"))
		{
			ReaderPO reader = new ReaderPO();
			reader.setRno(rno);
			reader.setRstyle(rstyle);
			reader.setRname(rname);
			reader.setRsex(rsex);
			reader.setRage(rage);
			reader.setRdept(rdept);
			int all = Integer.parseInt(rall);
			reader.setRall(all); 
					
			
			 if(operation.equals("delete"))
			{
				readerdao.deleteReader(reader);
			}
			else if(operation.equals("update"))
			{
				readerdao.updateReader(reader);
			}
		}
		List<ReaderPO> readers = readerdao.queryReaders();
		HttpSession session = request.getSession(true);
		session.setAttribute("Readerlist", readers);
		return "/Readerlist.jsp";
	}
}
