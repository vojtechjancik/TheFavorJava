package thefavor;

import java.util.Scanner;

import static thefavor.DatabaseOfFavors.contactList;

/**
 * Class represents object Contact and his creating
 */
public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String city;
    private String note;
    private static int dalsiId = 1;
    private int id;

    public Contact(String firstName, String lastName, String phoneNumber, String city, String note) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.note = note;
        id = dalsiId;
        dalsiId++;
    }

    public static Contact createContact() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n=== Guide to creating new contact ====\n");
        System.out.print("Write first name: ");
        String firstName = sc.nextLine();
        System.out.print("Write last name: ");
        String lastName = sc.nextLine();
        System.out.print("Write phoneNumber: ");
        String phoneNumber = sc.nextLine();
        System.out.print("Write city: ");
        String city = sc.nextLine();
        System.out.print("Write short note: ");
        String note = sc.nextLine();

        System.out.printf("\nYour new contact is:\nName: %s %s\nPhone Number: %s\nCity: %s\nNote: %s",
                firstName, lastName, phoneNumber, city, note);

        System.out.print("\nDo you want to save new contact? (y/n): ");
        String answer = sc.nextLine().trim().toLowerCase();

        if(answer.equals("y")) {
            Contact newContact = new Contact(firstName, lastName, phoneNumber, city, note);
            contactList.add(newContact);
            System.out.println("\nContact was saved.\n");
            return newContact;
        } else if (answer.equals("n")) {
            System.out.print("\nYour new contact is not saved.\n");
        } else {
            System.out.println("\nWrong command.\n");
        }
        return null;
    }

    public static void showAllContacts() {
        Scanner sc = new Scanner(System.in);

        if(contactList.isEmpty()) {
            System.out.println("\nNo data.\n");
            return;
        }

        System.out.print("\nDo you want to show all contacts? (y/n): ");
        String answer = sc.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
            System.out.println();
        } else if (answer.equals("n")) {
            System.out.println("All right, you don't want to see all favors.\n");
        } else {
            System.out.println("\nWrong answer.\n");
        }
    }

    public static void deleteAllContacts() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to delete all contacts? (y/n): ");
        String answer = sc.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {
            contactList.clear();
            System.out.println("\nAll contacts was deleted.\n");
        } else if (answer.equals("n")) {
            System.out.println("You didn't want to clear all data.\n");
        } else {
            System.out.println("Wrong answer.\n");
        }
    }

    @Override
    public String toString() {
        return "\nFirst and Last Name: " + firstName + " " + lastName + "\nPhoneNumber: " + phoneNumber + "\nCity: " + city +
                "\nShort note: " + note + "";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public static int getDalsiId() {
        return dalsiId;
    }

    public static void setDalsiId(int dalsiId) {
        Contact.dalsiId = dalsiId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
