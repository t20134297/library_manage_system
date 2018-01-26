package javabean;

public class BookPO
{
	private String Bno;
	private String Bname;
	private String Bwriter;
	private String Btopic;
	private int Ball;
	private int Bnow;
	
	public String getBno()
	{
		return this.Bno;
	}
	
	public String getBname()
	{
		return this.Bname;
	}
	
	public String getBwriter()
	{
		return this.Bwriter;
	}
	
	public String getBtopic()
	{
		return this.Btopic;
	}
	public int getBall()
	{
		return this.Ball;
	}
	public int getBnow()
	{
		return this.Bnow;
	}
	public void setBno(String Bno)
	{
		this.Bno = Bno;
	}
	
	public void setBname(String Bname)
	{
		this.Bname = Bname;
	}
	
	public void setBwriter(String Bwriter)
	{
		this.Bwriter = Bwriter;
	}
	
	public void setBtopic(String Btopic)
	{
		this.Btopic = Btopic;
	}
	public void setBall(int Ball)
	{
		this.Ball = Ball;
	}
	public void setBnow(int Bnow)
	{
		this.Bnow = Bnow;
	}
public String toString()
	{		
		return Bno+"       "+Bname+"         "+Bwriter+"       "+Btopic+"      "+Ball+"     "+Bnow;		
	}
}
