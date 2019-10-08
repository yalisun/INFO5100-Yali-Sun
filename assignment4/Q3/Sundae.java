package Q3;

public class Sundae extends IceCream {

	public Sundae(String name, int cost, String topping, int toppingPrice) {
		super(topping + "Sundae with\n" + name, cost + toppingPrice);
	}
}
