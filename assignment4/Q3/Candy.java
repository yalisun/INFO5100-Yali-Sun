package Q3;

class Candy extends DessertItem {
	private double weight;
	private int price;

	public Candy(String name, double weight, int price) {
		super(name);
		this.weight = weight;
		this.price = price;
	}

	@Override
	public int getCost() {
		return (int) Math.round(weight * price);
	}

	@Override
	public String getQuantity() {
		return weight + " lbs. @ " + DessertShop.cents2dollarsAndCentsmethod(price) + " /lb.\n";
	}
}
