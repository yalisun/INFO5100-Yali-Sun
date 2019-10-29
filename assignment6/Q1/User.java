package assignment6.Q1;

public class User {
    //Create a User class with attributes name, age, address, phoneNumber and bankAccountNumber.
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private int bankAccountNumber;

    public User(String name, int age, String phoneNumber, String address, int bankAccountNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int bankAccountNumber() {
        return this.bankAccountNumber;
    }

}
