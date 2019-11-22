package com.Squaa.RestaurantApp.DataLogic.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.filechooser.FileSystemView;

import com.Squaa.RestaurantApp.DataLogic.Order;
import com.Squaa.RestaurantApp.DataLogic.OrderItem;

public class Recept {
	//FOR CREATING TXT FILES FOR EACH ORDER CONTAINING ORDER_NUM,DATE,TIME
	static String orderPath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath()+ "\\Order";
	public Order order;
	
	 public Recept( Order order) {
			this.order = order;
		}
public void writeFile(Order order)
	{
		File file = new File(orderPath+"//"+"Order# "+order.getOrderNumber()+".txt");// Let me know if it work on your machine
		FileWriter fr = null;
			try {
		         	fr = new FileWriter(file);
		            fr.write("Order #: "+order.getOrderNumber()+"\n"
		                		+"Oder Date: "+order.getDate()+"\n"
		                		+"Order Time: "+order.getTime()+"\n");
		            ArrayList<OrderItem> orderItem;
		            orderItem= order.getOrder();
		            for(int i= 0;i<orderItem.size();i++)
		            {
		            	fr.write("Order Item: "+orderItem.get(i).getName()+"\n"
		            			+"Order Quantity: "+orderItem.get(i).getQuantity()+"\n"
		            			+"Order Cost: "+orderItem.get(i).getCost()+"\n");
		            }
		            
		        }
			catch (IOException e)
			{
				e.printStackTrace();
		    }
		    	try {
		             	fr.close();
		            } 
		    	catch (IOException e) 
		    	{
		    		e.printStackTrace();
		        }
		            
	}
		
		public void CreateFileDirectory() 
		 {
			 boolean dirFlag  = false;
			File stockDir = new File(orderPath);
			
			try
			{
				dirFlag = stockDir.mkdir();
			}
			catch(SecurityException Se)
			{
				System.out.println("Error marking directory"+ Se);
			}
			if(dirFlag)
			{
				System.out.println("Directory created Successfully");
			}
			else
			{
				System.out.println("Directory already exists");
			}
		 }
	}

		

