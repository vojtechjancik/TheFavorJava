package thefavor;

import java.util.ArrayList;
import java.util.List;

public class DatabaseOfFavors {
    public static List<FavorObject> favorObjectList = new ArrayList<>();
    public static List<Contact> contactList = new ArrayList<>();

    public static void databaseFavors() {
        Contact contact1 = new Contact("FirstName1", "LastName1", "123456789", "Brno", "pozn1");
        Contact contact2 = new Contact("FirstName2", "LastName2", "987654321", "Praha", "pozn2");
        Contact contact3 = new Contact("FirstName3", "LastName3", "963852741", "Ostrava", "pozn3");
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);

        favorObjectList.add(new FavorObject("Favor1", "Description1",
                contact1, 2, "input"));
        favorObjectList.add(new FavorObject("Favor2", "Description2",
                contact2, 1, "output"));
        favorObjectList.add(new FavorObject("Favor3", "Description3",
                contact3, 3, "input"));
    }
}
