package Q3;

import java.util.Vector;

public class Checkout {
	private static final String NEW_LINE = "\n";
	private Vector<DessertItem> dessertItem;

	public Checkout() {
		dessertItem = new Vector<>();
	}

	public int numberOfItems() {
		return dessertItem.size();
	}

	public void enterItem(DessertItem item) {
		dessertItem.add(item);
	}

	public int totalCost() {
		int cost = 0;
		for (DessertItem item : dessertItem) {
			cost += item.getCost();
		}
		return cost;
	}

	public int totalTax() {
		return (int) Math.round(totalCost() * DessertShop.TAX_RATE);
	}

	public void clear() {
		dessertItem.clear();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("      ");
		sb.append(DessertShop.NAME);
		sb.append(NEW_LINE);
		sb.append("      ");
		sb.append("--------------------");
		sb.append(NEW_LINE);
		for (DessertItem item: dessertItem) {
			sb.append(item.getQuantity());
			sb.append(String.format("%-10s %10s",
					item.getName(),
					DessertShop.cents2dollarsAndCentsmethod(item.getCost())));
			sb.append(NEW_LINE);
		}
		sb.append("Tax        ");
		int tax = totalTax();
		sb.append(DessertShop.cents2dollarsAndCentsmethod(tax));
		sb.append(NEW_LINE);
		sb.append("Total Cost        ");
		sb.append(DessertShop.cents2dollarsAndCentsmethod(tax + totalCost()));
		sb.append(NEW_LINE);
		return sb.toString();
	}
}
