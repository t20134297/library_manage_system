package controller;
import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

public interface IAction 
{
	public String execute(HttpServletRequest request,Connection dbconnection );
}
