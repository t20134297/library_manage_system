package controller;

import java.util.List;
import java.sql.Connection;

import javabean.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BookAction implements IAction 
{
	public String execute(HttpServletRequest request,Connection cn)
	{
		BookDAO bookdao = new BookDAO(cn);
		String operation = request.getParameter("operation");
		if(operation.equals("insert") || operation.equals("delete") || operation.equals("update"))
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
			
			if(operation.equals("insert"))
			{
				if(bookdao.queryBookhave(bno)) 
					return "/Bookaddagain.jsp";
				bookdao.addBook(book);
			}
			else if(operation.equals("delete"))
			{
				bookdao.deleteBook(book);
			}
			else if(operation.equals("update"))
			{
				bookdao.updateBook(book);
			}
		}
		List<BookPO> books = bookdao.queryBooks();
		HttpSession session = request.getSession(true);
		session.setAttribute("Booklist", books);
		return "/Booklist.jsp";
	}
}
