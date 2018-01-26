package javabean;
import java.sql.*;
import java.util.ArrayList;
public class PurchaseDAOTest 
{
private DatabaseManager dbManager;
private PurchaseDAO dao;
public PurchaseDAOTest()
{
	String jdbcDriver = "com.mysql.jdbc.Driver";
	String dbUrl = "jdbc:mysql://localhost:3306/JavaLibrary";
	String dbUser = "root";
	String dbPassword = "manager";
	dbManager = new DatabaseManager(jdbcDriver,dbUrl,dbUser,dbPassword);
	dao = new PurchaseDAO(dbManager.getConnection());
}
public void closeConnection()
{
	dbManager.clodseConnection();
}
private void dropTable()
{
	try
	{
		Statement stmt = dbManager.getConnection().createStatement();
		stmt.execute("drop table Purchase");
		System.out.println("drop table Purchase succeful");
	}
	catch(Exception e)
	{
		System.out.println("dropTable false     "+e);
	}
}
private void createTable()
{
	try{
		Statement stmt= dbManager.getConnection().createStatement();		
		stmt.execute("create table Purchase (Pno varchar(12)primary key ,Pname varchar(12),Pwriter varchar(12),Ptopic varchar(12),Pall int,Pnow int,Pchange varchar(12))");
		System.out.println("Created table Purchase");
	}catch(Exception e){
		System.out.println("Created table Purchase error:"+e);
	}		
}
private void insertInitRecords()
{
	ArrayList<PurchasePO> purs = new ArrayList<PurchasePO>();
	PurchasePO pur = new PurchasePO();
	pur.setPno("110");
	pur.setPname("��¹ԭ");
	pur.setPwriter("����ʵ");
	pur.setPtopic("��ѧ");
	pur.setPall(5);
	pur.setPchange("yes");
	pur.setPnow(5);
	purs.add(pur);
    
	pur = new PurchasePO();
    pur.setPno("111");
	pur.setPname("����");
	pur.setPwriter("����");
	pur.setPtopic("��ѧ");
	pur.setPall(5);
	pur.setPchange("yes");
	pur.setPnow(5);
	purs.add(pur);
    
	pur = new PurchasePO();
    pur.setPno("112");
	pur.setPname("��մ�");
	pur.setPwriter("��ɮ");
	pur.setPtopic("��ѧ");
	pur.setPall(4);
	pur.setPchange("yes");
	pur.setPnow(5);
	purs.add(pur);
    
    dao.addPurchases(purs);
    
    System.out.println("insert 3 records");
    System.out.println("------------�г�������¼--------");
    testqueryPurchases();
}
private void testqueryPurchases()
{
	System.out.println("���      "+"��Ŀ           "+" ����            "+"����                  "+"�ܹ�     "+"���"+"�Ƿ��� ");
	ArrayList<PurchasePO> list = dao.queryPurchases();
	if(list != null && list.size()>0)
	{
		for(PurchasePO one:list)
			System.out.println(one.toString());
	}
}
private void testinsertRecord()
{
	PurchasePO pur = new PurchasePO();
	pur.setPno("2222");
	pur.setPname("��·ԭ��");
	pur.setPwriter("�");
	pur.setPtopic("�Զ���");
	pur.setPall(5);
	pur.setPnow(5);
	pur.setPchange("no");
	dao.addPurchase(pur);
	System.out.println();
	System.out.println("��ӵ�·ԭ����");
	testqueryPurchases();
}
private void testupdatePurchase()
{
	PurchasePO pur = dao.queryPurchaseByPno("111");
	pur.setPname("����");
	pur.setPwriter("������");
	pur.setPtopic("���");
	pur.setPall(5);
	pur.setPchange("no");
	dao.updatePurchase(pur);
	System.out.println();
	System.out.println("����111���Ŀ¼");
	testqueryPurchases();
}
private void tesdeletePurchase()
{
	PurchasePO pur = dao.queryPurchaseByPno("110");
	dao.deletePurchase(pur);
	System.out.println();
	System.out.println("ɾ��110����б�");
	testqueryPurchases();
}
public static void main(String[] args)
{
	PurchaseDAOTest bdt = new PurchaseDAOTest();
	bdt.dropTable();
	bdt.createTable();
	bdt.insertInitRecords();
	bdt.testinsertRecord();
	bdt.testupdatePurchase();
	bdt.tesdeletePurchase();
	//bdt.dropTable();
}
}
