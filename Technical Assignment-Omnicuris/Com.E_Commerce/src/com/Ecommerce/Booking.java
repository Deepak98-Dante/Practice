package com.Ecommerce;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Booking extends Curd_Progress{

	public void singlebook(String item,int quantity,String Email)
	{
		try {
		Connection connect=Curd_Progress.Conn();
		Statement stmt =connect.createStatement();
		String q6="Select quanity from ITEMS where name='"+item+"'";
		ResultSet rs=stmt.executeQuery(q6);
		int aq=0;
		while(rs.next())
		{
			 aq=rs.getInt(1);
		}
		int o_id=(int)(Math.random()*((150-10)+1))+10;
		if(aq >= quantity)
		{
			System.out.print("Stock is Available");
			String q5="insert into BOOK values ('"+o_id+"','"+item+"','"+quantity+"','"+Email+"')";
			String q7="update Items set quanity = '" + (aq-quantity) +"' where name='"+item+"'";
			int a=stmt.executeUpdate(q5);
			int b=stmt.executeUpdate(q7);
			
		}
		else
		{
			System.out.print("Stock Unavailable");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void listbook()
	{
		try {
		Connection connect=Curd_Progress.Conn();
		Statement stmt =connect.createStatement();
		String q6="Select * from BOOK";
		ResultSet rs=stmt.executeQuery(q6);
		System.out.println("Order_ID\tITEM_NAME\tQUANTITY\tEMAIL");
		while (rs.next())
		{
			
			
			int id=rs.getInt("ORDER_ID");
			String item_Name=rs.getString("ITEM_NAME");
			int quanity=rs.getInt("QUANITY");
			String email=rs.getString("EMAIL");
			System.out.format("%s\t%s\t%s\t%s\t\n", id,item_Name,quanity,email);
		}
		
		
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
