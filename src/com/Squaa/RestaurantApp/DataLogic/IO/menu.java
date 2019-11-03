package com.Squaa.RestaurantApp.DataLogic.IO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class menu {
	private int idnum;
	private String name;
	private int time;
	private int quantity;
	private double price;
	
	public menu(int id, String foodname,int preptime,int amount,double cost)
	{
		idnum = id;
		name = foodname;
		time = preptime;
		quantity = amount;
		price = cost;
	}
	public int getid() 
	{
		return idnum;
	}
	public String getname() 
	{
		return name;
	}
	public int gettime() 
	{
		return time;
	}
	public int getquantity() 
	{
		return quantity;
	}
	public double getprice() 
	{
		return price;
	}
	 
	public static void main(String args[])
	{
		database data  = new database();
    	 ResultSet rs;
    	 
    	 try {
    		rs = data.displayUsers();  
    		 while(rs.next())
    		 {
    			 System.out.println(rs.getInt("id")+ " " +rs.getString("name")+" "+rs.getInt("time"));
    		 }
    		
    	} catch (ClassNotFoundException e) {
    		e.printStackTrace();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	

}
