
public class MenuItem extends Dish{
	private int cost;
	private int preptime;
	public MenuItem(int cost, int preptime) {
		super();
		this.cost = cost;
		this.preptime = preptime;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getPreptime() {
		return preptime;
	}
	public void setPreptime(int preptime) {
		this.preptime = preptime;
	}

}
