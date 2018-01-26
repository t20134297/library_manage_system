package javabean;

public class ReaderPO 
{
	private String Rno;
	private String Rstyle;
	private String Rname;
	private String Rsex;
	private String Rage;
	private String Rdept;
	private int Rall;
	public String getRno()
	{
		return this.Rno;
	}
	public String getRstyle()
	{
		return this.Rstyle;
	}
	public String getRname()
	{
		return this.Rname;
	}
	public String getRsex()
	{
		return this.Rsex;
	}
	public String getRage()
	{
		return this.Rage;
	}
	public String getRdept()
	{
		return this.Rdept;
	}
	public int getRall()
	{
		return this.Rall;
	}
	public void setRno(String Rno)
	{
		this.Rno = Rno;
	}
	public void setRstyle(String Rstyle)
	{
		this.Rstyle = Rstyle;
	}
	public void setRname(String Rname)
	{
		this.Rname = Rname;
	}
	public void setRsex(String Rsex)
	{
		this.Rsex = Rsex;
	}
	public void setRage(String Rage)
	{
		this.Rage = Rage;
	}
	public void setRdept(String Rdept)
	{
		this.Rdept = Rdept;
	}
	public void setRall(int Rall)
	{
		this.Rall = Rall;
	}
	public String toString()
	{
		return Rno +"     "+Rstyle+"      "+Rname+"      "+Rsex+"       "+Rage+"       "+Rdept+"    "+Rall; 
	}
}
