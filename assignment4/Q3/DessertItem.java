package Q3;

abstract class DessertItem {
	protected String name;
	public abstract int getCost();
	public abstract String getQuantity();

	public DessertItem(String name) {
		this.name = name;
	}

	public final String getName() {
		return this.name;
	}
}
