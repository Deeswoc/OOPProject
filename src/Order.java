import java.util.ArrayList;

public class Order {
	private ArrayList<MenuItem> order;
	public int netTotal()
	{
		int total = 0;
		for(int i=0;i<order.size();i++)
		{
			total+=order.get(i).getCost();
		}
		
		return total;
	}
	public int newtime()
	{
		int total = 0;
		for(int i = 0;i<order.size();i++)
		{
			total+=order.get(i).getPreptime();
		}
		return total;
	}


}
