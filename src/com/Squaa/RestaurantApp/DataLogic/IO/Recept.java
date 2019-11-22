package com.Squaa.RestaurantApp.DataLogic.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.regex.Pattern;

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
        PrintWriter printWriter;
			try {
                fr = new FileWriter(file);
                printWriter = new PrintWriter(fr);
                fr.write("Order #: "+order.getOrderNumber()+"\n"
                            +"Oder Date: "+order.getDate()+"\n"
                            +"Order Time: "+order.getTime().split(Pattern.quote("."))[0]+"\n");

                printWriter.println("");
                ArrayList<OrderItem> orderItem;

                orderItem= order.getOrder();


                printWriter.printf("\t\t%-20s%-10s%11s\n", "Description", "Quantity", "Subtotal");
                printWriter.printf("\t\t");
                for(int i = 0; i < 41; i++){
                    printWriter.printf("-");
                }
                printWriter.println("");
                for(int i= 0;i<orderItem.size();i++)
                {
                    printWriter.printf("\t\t%-20s%7d%5s$%8d\n", orderItem.get(i).getName(), orderItem.get(i).getQuantity(), "",orderItem.get(i).subTotal());
                }
                printWriter.printf("\t\t");
                for(int i = 0; i < 41; i++){
                    printWriter.printf("-");
                }
                printWriter.println("");
                printWriter.printf("\t\t%-32s$%8d", "Total", order.getTotal());
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

		

