package WQ_0922;

public class PersonalContact extends Contact {
    String relationship;

    public PersonalContact(String name, String phoneNumber, String relationship) {
        super(name, phoneNumber);
        this.relationship = relationship;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(", 관계: " + relationship);
    }
}
