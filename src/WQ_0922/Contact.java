package WQ_0922;

public class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void displayInfo() {
        System.out.print("이름: " + name);
        System.out.print(", 전화번호: " + phoneNumber);
    }
}
