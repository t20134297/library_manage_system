package javabean;

public class BorrowPO 
{
	private String bno;
	private String bname;
	private String bookno;
	private String bookname;
	private String borrowdate;
	private String returndate;
	public String getbno()
	{
		return this.bno;
	}
	public String getbname()
	{
		return this.bname;
	}
	public String getbookno()
	{
		return this.bookno;
	}
	public String getbookname()
	{
		return this.bookname;
	}
	public String getborrowdate()
	{
		return this.borrowdate;
	}
	public String getreturndate()
	{
		return this.returndate;
	}
	public void setbno(String bno)
	{
		this.bno = bno;
	}
	public void setbname(String bname)
	{
		this.bname = bname;
	}
	public void setbookno(String bookno)
	{
		this.bookno = bookno;
	}
	public void setbookname(String bookname)
	{
		this.bookname = bookname;
	}
	public void setborrowdate(String borrowdate)
	{
		this.borrowdate = borrowdate;
	}
	public void setreturndate(String returnwdate)
	{
		this.returndate = returnwdate;
	}
	public String toString()
	{
		return bno +"     "+bname+"     "+bookno+"     "+bookname+"     "+borrowdate+"     "+returndate;
	}
}
