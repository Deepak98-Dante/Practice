package com.Ecommerce;

import java.sql.*;

public class Curd_Progress {
	
	public static Connection Conn() {
		
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Deepak","Deepak");
	    
		if (con!=null)
			System.out.println("Connected to DB");
		else
		System.out.println("Not Connected to DB");
	 return con;
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	return null;
	}
	public void insert(int id,String name,int quantity) {
		try {
		Connection connect=Curd_Progress.Conn();
		Statement stmt =connect.createStatement();
		String q1="insert into ITEMS values ('"+id+"','"+name+"','"+quantity+"')";
		int x=stmt.executeUpdate(q1);
		if(x>0)
		{
			System.out.println("Successfully inseted");
		}
		else
			System.out.println("insertion Failed");
		connect.close();
		}
		catch (Exception e)
		{
		System.out.println(e);	
		}
		
	}
	public void updatequantity(int id,int quantity) {
		try {
		Connection connect=Curd_Progress.Conn();
		Statement stmt =connect.createStatement();
		String q2="update Items set quanity = '" + quantity +"' where id='"+id+"'";
		int x=stmt.executeUpdate(q2);
		if(x>0)
		{
			System.out.println("Successfully Stock Updated");
		}
		else
			System.out.println("Updating Stock Failed.....");
		connect.close();
		}
		catch (Exception e)
		{
		System.out.println(e);	
		}
	}
		public void delete(int id) {
			try {
			Connection connect=Curd_Progress.Conn();
			Statement stmt =connect.createStatement();
			String q3="Delete from ITEMS Where id='"+id+ "'";
			int x=stmt.executeUpdate(q3);
			if(x>0)
			{
				System.out.println("Successfully Item Removed from List");
			}
			else
				System.out.println("Updating Stock Failed.....");
			connect.close();
			}
			catch (Exception e)
			{
			System.out.println(e);	
			}
		}
			public void list() {
				try {
				Connection connect=Curd_Progress.Conn();
				Statement stmt =connect.createStatement();
				String q4="Select name from ITEMS";
				ResultSet rs=stmt.executeQuery(q4);
				System.out.println("Item Name:");
				while(rs.next())
				{
					System.out.println(rs.getString(2));
				}
				
				connect.close();
				}
				catch (Exception e)
				{
				System.out.println(e);	
				}
	}
	public static void main(String x[]) {
	 //Curd_Progress c=new Curd_Progress();
		Booking b=new Booking();
	 b.singlebook("Box", 10, "deepakrishnan@gmail.com");
	 b.listbook();
	}
}
