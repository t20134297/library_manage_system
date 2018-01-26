package javabean;
import java.sql.*;
import java.util.ArrayList;

import javax.print.DocFlavor.READER;
public class ReaderDAOTest
{
	private DatabaseManager dbManager;
	private ReaderDAO dao;
	public ReaderDAOTest()
	{
		String jdbcDriver = "com.mysql.jdbc.Driver";;
		String dbUrl = "jdbc:mysql://localhost:3306/JavaLibrary";
		String dbUser = "root";
		String dbPassword ="manager";
		dbManager = new DatabaseManager(jdbcDriver,dbUrl,dbUser,dbPassword);
		dao = new ReaderDAO(dbManager.getConnection());
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
		stmt.execute("drop table Reader");
		System.out.println("dropTable successfully");
		}
		catch(Exception e)
		{
			System.out.println("dropTable false     "+e);
		}
	}
	private void createTable()
	{
		try
		{
			Statement stmt = dbManager.getConnection().createStatement();
			stmt.execute("create table Reader(Rno varchar(20) primary key,Rstyle varchar(12),Rname varchar(12) ,Rsex varchar(12),Rage varchar(12),Rdept varchar(12),Rall int)");
			System.out.println("create table reader successfully");
		}
		catch(Exception e)
		{
			System.out.println("createTable false      "+e);
		}
	}
	private void insertInitRecoeds()
	{
		ArrayList<ReaderPO> readers = new ArrayList<ReaderPO>();
		ReaderPO reader = new ReaderPO() ;
		reader.setRno("20130001");
		reader.setRname("������");
		reader.setRsex("��");
		reader.setRage("20");
		reader.setRdept("��Ϣ");
		reader.setRall(2);
		reader.setRstyle("student");
		readers.add(reader);
		
		reader = new ReaderPO();
		reader.setRno("20130002");
		reader.setRname("���");
		reader.setRsex("��");
		reader.setRage("20");
		reader.setRdept("����");
		reader.setRall(2);
		reader.setRstyle("teacher");
		readers.add(reader);
		
		reader = new ReaderPO();
		reader.setRno("20130003");
		reader.setRname("������");
		reader.setRsex("Ů");
		reader.setRage("22");
		reader.setRdept("��е");
		reader.setRall(2);
		reader.setRstyle("student");
		readers.add(reader);
		
		dao.addReaders(readers);
		
		System.out.println("��ʼ��������Ϣ ");
		System.out.println("-------������ϢΪ---------");
		testqueryReaders();
	}
	private void testqueryReaders()
	{
		System.out.println("���ߺ�        "+"��������        "+"��������        "+"�����Ա�          "+"��������          "+"����ѧԺ"+"       "+"��������");
		ArrayList<ReaderPO> list = dao.queryReaders();
		if(list != null && list.size()>0)
		{
			for(ReaderPO one:list)
				System.out.println(one.toString());
		}
	}
	private void insertReadertest()
	{
		ReaderPO reader = new ReaderPO();
		reader.setRno("20130004");
		reader.setRname("������");
		reader.setRsex("��");
		reader.setRage("18");
		reader.setRdept("����");
		reader.setRall(2);
		reader.setRstyle("teacher");
		dao.addReader(reader);
		System.out.println();
		System.out.println("�����������ı��");
		testqueryReaders();
	}
	private void testupdateReader()
	{
		ReaderPO reader = dao.queryReaderByRno("20130001");
		reader.setRdept("����");
		reader.setRage("12");
		reader.setRname("������");
		reader.setRsex("��");
		reader.setRall(2);
		reader.setRstyle("fffff");
		dao.updateReader(reader); 
		
		System.out.println();
		System.out.println("����20130001��ı��");
		testqueryReaders();
	}
	private void testdeleteReader()
	{
		ReaderPO reader = dao.queryReaderByRno("20130004");
		dao.deleteReader(reader);
		System.out.println();
		System.out.println("ɾ��20130004����б�");
		testqueryReaders();
	}
	private void testreaderborrow()
	{
		ReaderPO reader = dao.queryReaderByRno("20130001");
		dao.readerborrow(reader);
		System.out.println();
		System.out.println("20130001���ĺ���б�");
		testqueryReaders();
	}
	private void testreaderreturn()
	{
		ReaderPO reader = dao.queryReaderByRno("20130002");
		dao.readerreturn(reader);
		System.out.println();
		System.out.println("20130002�黹����б�");
		testqueryReaders();
	}
	private void testqueryhave()
	{
		System.out.println("�����Ƿ���20130004");
		System.out.println(dao.queryhave("20130004"));
	}
	public static void main(String[] args)
	{
		ReaderDAOTest rdt = new ReaderDAOTest();
		rdt.dropTable();
		rdt.createTable();
		rdt.insertInitRecoeds();
		rdt.insertReadertest();
		rdt.testupdateReader();
		rdt.testdeleteReader();
		rdt.testreaderborrow();
		rdt.testreaderreturn();
		rdt.testqueryhave();
	}
}