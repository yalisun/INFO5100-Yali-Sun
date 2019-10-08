package Q3;

public class DessertShop {

	public static final double TAX_RATE = 0.065;
	public static final String NAME = "M & M Dessert Shop";

	public static String cents2dollarsAndCentsmethod(int cents) {
		if (cents < 100) {
			return String.format(".%d", cents);
		}
		return String.format("%.2f", cents / 100D);
	}

}
