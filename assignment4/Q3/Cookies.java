package Q3;

public class Cookies extends DessertItem{
	private int number;
	private int price;

	public Cookies(String name, int number, int price) {
		super(name);
		this.number = number;
		this.price = price;
	}

	@Override
	public int getCost() {
		return (int) Math.round(number * price / 12D);
	}

	@Override
	public String getQuantity() {
		return number + " @ " + DessertShop.cents2dollarsAndCentsmethod(price) + " /dz.\n";
	}
}
