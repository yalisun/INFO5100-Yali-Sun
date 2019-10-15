package assignment5.Q5;

import java.util.Calendar;

public class Dog extends Pet implements Boardable {
	private String size;
	private Calendar boardStart;
	private Calendar boardEnd;

	public Dog(String name, String ownerName, String color, String size) {
		super(name, ownerName, color);
		this.size = size;
	}

	public String getSize() {
		return this.size;
	}

	public String toString() {
		return String.format(
				"%s\nSize: %s",
				super.toString(), getSize());
	}

	@Override
	public void setBoardStart(int month, int day, int year) {
		boardStart = Calendar.getInstance();
		boardStart.set(year, month - 1, day);
	}

	@Override
	public void setBoardEnd(int month, int day, int year) {
		boardEnd = Calendar.getInstance();
		boardEnd.set(year, month - 1, day);
	}

	@Override
	public boolean boarding(int month, int day, int year) {
		Calendar boarding = Calendar.getInstance();
		boarding.set(year, month - 1, day);
		if (boarding.before(boardStart)) {
			return false;
		}
		if (boarding.after(boardEnd)) {
			return false;
		}
		return true;
	}

}
