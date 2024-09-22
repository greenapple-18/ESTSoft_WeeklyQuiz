package WQ_0922;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    public static void main(String[] args) {
        String selectNumber;
        Scanner scanner = new Scanner(System.in);
        List<Contact> contacts = new ArrayList<>();

        do {
            System.out.println("1. 비즈니스 연락처 추가");
            System.out.println("2. 개인 연락처 추가");
            System.out.println("3. 연락처 출력");
            System.out.println("4. 연락처 검색");
            System.out.println("5. 종료");
            System.out.print("메뉴를 선택해주세요: ");
            selectNumber = scanner.nextLine();

            switch (selectNumber) {
                case "1":
                    addBusinessContact(scanner, contacts);
                    break;
                case "2":
                    addPersonalContact(scanner, contacts);
                    break;
                case "3":
                    displayContacts(contacts);
                    break;
                case "4":
                    searchContact(scanner, contacts);
                    break;
                case "5":
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("올바른 번호를 입력해 주세요.");
                    break;
            }
        } while (!selectNumber.equals("5"));
    }

    public static void addBusinessContact(Scanner scanner, List<Contact> contacts) {
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("회사명을 입력하세요: ");
        String company = scanner.nextLine();

        contacts.add(new BusinessContact(name, phoneNumber, company));
        System.out.println("\n\n비즈니스 연락처가 추가되었습니다.\n\n");
    }

    public static void addPersonalContact(Scanner scanner, List<Contact> contacts) {
        System.out.print("이름을 입력하세요: ");
        String name = scanner.nextLine();
        System.out.print("전화번호를 입력하세요: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("관계를 입력하세요: ");
        String relationship = scanner.nextLine();

        contacts.add(new PersonalContact(name, phoneNumber, relationship));
        System.out.println("\n\n개인 연락처가 추가되었습니다.\n\n");
    }

    public static void displayContacts(List<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("\n\n연락처가 비어있습니다.\n\n");
        } else {
            System.out.println("\n\n\n----------------------------------------");
            for (Contact contact : contacts) {
                contact.displayInfo();
                System.out.println("----------------------------------------");
            }
            System.out.println("\n\n\n");
        }
    }

    // 연락처 검색
    public static void searchContact(Scanner scanner, List<Contact> contacts) {
        System.out.print("검색할 이름을 입력하세요: ");
        String name = scanner.nextLine();
        boolean found = false;

        System.out.println("\n\n\n");
        for (Contact contact : contacts) {
            if (contact.getName().equals(name)) {
                System.out.println("----------------------------------------");
                contact.displayInfo();
                found = true;
            }
        }
        System.out.println("----------------------------------------");
        System.out.println("\n\n\n");
        if (!found) {
            System.out.println("\n\n\n연락처를 찾을 수 없습니다.\n\n\n");
        }
    }
}
