package controller;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;

import javabean.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class BorrowAction implements IAction 
{
	public String execute(HttpServletRequest request,Connection cn)
	{
		BorrowDAO borrowdao = new BorrowDAO(cn);
		ReaderDAO readerdao = new ReaderDAO(cn);
		BookDAO bookdao = new BookDAO(cn);
		HttpSession session=request.getSession(true);
		String operation = request.getParameter("operation");
		if(operation.equals("insert"))
		{
			Calendar riqi = Calendar.getInstance();
			int year = riqi.get(Calendar.YEAR);  
		    int month = riqi.get(Calendar.MONTH)+1 ; 
		    int day = riqi.get(Calendar.DAY_OF_MONTH);
		    String borrowtime = year+"年"+month+"月"+day+"日";
		    String returntime = "未还";
			String strborrow0 = request.getParameter("bno");
			String[] strborrows0 = strborrow0.split(" ");
			String strbno0 = strborrows0[0];
			String strbname0 = strborrows0[1];
			String strbook0 =request.getParameter("bookno");
			String[] strbooks0 = strbook0.split(" ");
			String strbookno0 = strbooks0[0];
			String strbookname0 = strbooks0[1];
			BorrowPO borrow0 = new BorrowPO();
			
			if(borrowdao.queryBorrowBybnoandbookno(strbno0, strbookno0))
			{
				return "/Borrowagain.jsp";
			}
			borrow0.setbno(strbno0);
			borrow0.setbname(strbname0);
			borrow0.setbookno(strbookno0);
			borrow0.setbookname(strbookname0);
			borrow0.setborrowdate(borrowtime);
			borrow0.setreturndate(returntime); 
			borrowdao.addBorrow(borrow0); 
			
			BookPO book0 = bookdao.queryBookByBno(strbookno0);
			bookdao.Bookless(book0);
			
			ReaderPO reader0 = readerdao.queryReaderByRno(strbno0);
			readerdao.readerborrow(reader0); 
			
		}
		if(operation.equals("return"))
		{
			BorrowPO borrow1 =new BorrowPO();
			String strborrowno1 = request.getParameter("no");
			borrow1.setbno(strborrowno1);
			String strborrowname1 = request.getParameter("name");
			borrow1.setbname(strborrowname1);
			String strbookno1 = request.getParameter("bookno");
			borrow1.setbookno(strbookno1);
			String strbookname1 = request.getParameter("bookname");
			borrow1.setbookname(strbookname1);
			String borrowdate = request.getParameter("borrowdate");
			borrow1.setborrowdate(borrowdate); 
			Calendar riqi1 = Calendar.getInstance();
			int year1 = riqi1.get(Calendar.YEAR);  
		    int month1 = riqi1.get(Calendar.MONTH)+1 ; 
		    int day1 = riqi1.get(Calendar.DAY_OF_MONTH);
		    String returntime = year1+"年"+month1+"月"+day1+"日";
		    borrow1.setreturndate(returntime); 
			borrowdao.updateBorrow(borrow1);
			
			BookPO book1 = bookdao.queryBookByBno(strbookno1);
			bookdao.Bookmore(book1);
			
			ReaderPO reader1 = readerdao.queryReaderByRno(strborrowno1);
			readerdao.readerreturn(reader1); 
		}	
		if(operation.equals("delete"))
		{
			BorrowPO borrow2 =new BorrowPO();
			String strborrowno2 = request.getParameter("no");
			borrow2.setbno(strborrowno2);
			String strborrowname2 = request.getParameter("name");
			borrow2.setbname(strborrowname2);
			String strbookno2 = request.getParameter("bookno");
			borrow2.setbookno(strbookno2);
			String strbookname2 = request.getParameter("bookname");
			borrow2.setbookname(strbookname2);
			String borrowdate2 = request.getParameter("borrowdate");
			borrow2.setborrowdate(borrowdate2);
			String returndate2 = request.getParameter("returndate");
			borrow2.setreturndate(returndate2); 
			
			borrowdao.deleteBorrow(borrow2); 
		}
		if(operation.equals("search"))
		{
			String key = request.getParameter("key");
			String word = request.getParameter("word");
			if(key.equals("书名"))
			{
				List<BookPO> booksname = bookdao.queryBookByBname(word);
				if(booksname.size() == 0)
					return "/Borrowno.jsp";
				session.setAttribute("Booksname",booksname);
				List<ReaderPO> readers = readerdao.queryReaders();
				session.setAttribute("Readerlist",readers);
					return "/Searchresult.jsp";
			}
			if(key.equals("作者"))
			{
				List<BookPO> booksname = bookdao.queryBookByBwriter(word);
				if(booksname.size() == 0)
					return "/Borrowno.jsp";
				session.setAttribute("Booksname",booksname);
				List<ReaderPO> readers = readerdao.queryReaders();
				session.setAttribute("Readerlist",readers);
					return "/Searchresult.jsp";
			}
			if(key.equals("主题"))
			{
				List<BookPO> booksname = bookdao.queryBookByBtopic(word);
				if(booksname.size() == 0)
					return "/Borrowno.jsp";
				session.setAttribute("Booksname",booksname);
				List<ReaderPO> readers = readerdao.queryReaders();
				session.setAttribute("Readerlist",readers);
					return "/Searchresult.jsp";
			}
		}
		if(operation.equals("searchinsert"))
		{
			Calendar riqi = Calendar.getInstance();
			int year = riqi.get(Calendar.YEAR);  
		    int month = riqi.get(Calendar.MONTH)+1 ; 
		    int day = riqi.get(Calendar.DAY_OF_MONTH);
		    String borrowtime = year+"年"+month+"月"+day+"日";
		    String returntime = "未还";
			String strborrow0 = request.getParameter("bno");
			String[] strborrows0 = strborrow0.split(" ");
			String strbno0 = strborrows0[0];
			String strbname0 = strborrows0[1];
			String bookno = request.getParameter("no");
			String bookname=request.getParameter("name");
			BorrowPO borrow0 = new BorrowPO();
			
			if(borrowdao.queryBorrowBybnoandbookno(strbno0, bookno))
			{
				return "/Borrowagain.jsp";
			}
			borrow0.setbno(strbno0);
			borrow0.setbname(strbname0);
			borrow0.setbookno(bookno);
			borrow0.setbookname(bookname);
			borrow0.setborrowdate(borrowtime);
			borrow0.setreturndate(returntime); 
			borrowdao.addBorrow(borrow0); 
			
			BookPO book0 = bookdao.queryBookByBno(bookno);
			bookdao.Bookless(book0);
			
			ReaderPO reader0 = readerdao.queryReaderByRno(strbno0);
			readerdao.readerborrow(reader0); 
			
		}
		//List<ScorePO> scores=scoreDAO.queryScores();	
		//CourseDAO courserDAO=new CourseDAO(cn);
		//List<CoursePO> courses=courserDAO.queryCourses();
		//session.setAttribute("courseList", courses);
		List<BorrowPO> Borrowlist = borrowdao.queryBorrows();
		request.setAttribute("Borrowlist",Borrowlist );
		List<ReaderPO> readers = readerdao.queryReaders();
		session.setAttribute("Readerlist",readers);
		List<BookPO> books = bookdao.queryBooks();
		session.setAttribute("Booklist",books);
		return "/Borrowlist.jsp";
	}
}
