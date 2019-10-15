package assignment5.Q3;

public class FullTime extends Employee {

	public FullTime(String name, int paymentPerHour) {
		super(name, paymentPerHour);
	}

	@Override
	public int calculateSalary() {
		return 8 * getPaymentPerHour();
	}
}
