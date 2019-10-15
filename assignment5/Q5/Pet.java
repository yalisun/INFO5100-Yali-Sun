package assignment5.Q5;

public class Pet {
	public static final int MALE = 0;
	public static final int FEMALE = 1;
	public static final int SPAYED = 2;
	public static final int NEUTERED = 3;
	private static final String[] SEX_STRING = {"male", "female", "spayed", "neutered"};

	private String name;
	private String ownerName;
	private String color;
	protected int sex;

	public Pet(String name, String ownerName, String color) {
		this.name = name;
		this.ownerName = ownerName;
		this.color = color;
	}

	public String getPetName() {
		return this.name;
	}

	public String getOwnerName() {
		return this.ownerName;
	}

	public String getColor() {
		return this.color;
	}

	public void setSex(int sexid) {
		this.sex = sexid;
	}

	public String getSex() {
		return SEX_STRING[sex];
	}

	public String toString() {
		return String.format("%s owned by %s\nColor: %s\nSex: %s", name, ownerName, getColor(), getSex());
	}

	public static void main(String[] args) {
	}
}
