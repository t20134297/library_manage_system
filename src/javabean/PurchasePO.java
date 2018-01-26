package javabean;

public class PurchasePO 
{
	private String Pno;
	private String Pname;
	private String Pwriter;
	private String Ptopic;
	private int Pall;
	private int Pnow;
	private String Pchange;
	
	public String getPno()
	{
		return this.Pno;
	}
	
	public String getPname()
	{
		return this.Pname;
	}
	
	public String getPwriter()
	{
		return this.Pwriter;
	}
	
	public String getPtopic()
	{
		return this.Ptopic;
	}
	public int getPall()
	{
		return this.Pall;
	}
	public int getPnow()
	{
		return this.Pnow;
	}
	public String getPchange()
	{
		return this.Pchange;
	}
	public void setPno(String Pno)
	{
		this.Pno = Pno;
	}
	
	public void setPname(String Pname)
	{
		this.Pname = Pname;
	}
	
	public void setPwriter(String Pwriter)
	{
		this.Pwriter = Pwriter;
	}
	
	public void setPtopic(String Ptopic)
	{
		this.Ptopic = Ptopic;
	}
	public void setPall(int Pall)
	{
		this.Pall = Pall;
	}
	public void setPnow(int Pnow)
	{
		this.Pnow = Pnow;
	}
	public void setPchange(String Pchange)
	{
		this.Pchange = Pchange;
	}
	public String toString()
	{		
		return Pno+"       "+Pname+"         "+Pwriter+"       "+Ptopic+"      "+Pall+"      "+Pnow+"      "+Pchange;		
	}
}
