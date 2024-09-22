package WQ_0922;

public class BusinessContact extends Contact {
    private String company;

    public BusinessContact(String name, String phoneNumber, String company) {
        super(name, phoneNumber);
        this.company = company;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", 회사명: " + company);
    }

}
