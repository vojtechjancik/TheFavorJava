package thefavor;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static thefavor.Contact.createContact;
import static thefavor.DatabaseOfFavors.contactList;
import static thefavor.DatabaseOfFavors.favorObjectList;

/**
 * Class represents object Favor, creating, deleting and editing
 */
public class FavorObject {
    private int levelOfFavor;
    private String nameOfFavor;
    private String description;
    private String favorInputOutput;
    private LocalDateTime dateTime;
    private Contact contact;

    public FavorObject(String nameOfFavor, String description, Contact contact, int levelOfFavor, String favorInputOutput) {
        this.nameOfFavor = nameOfFavor;
        this.description = description;
        this.contact = contact;
        this.levelOfFavor = levelOfFavor;
        this.favorInputOutput = favorInputOutput;
        this.dateTime = LocalDateTime.now();
    }

    public String getNameOfFavor() {
        return nameOfFavor;
    }

    public String getDescription() {
        return description;
    }

    public Contact getContact() {
        return contact;
    }

    public int getLevelOfFavor() {
        return levelOfFavor;
    }

    public String getFavorInputOutput() {
        return favorInputOutput;
    }

    public void setNameOfFavor(String nameOfFavor) {
        this.nameOfFavor = nameOfFavor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public void setLevelOfFavor(int levelOfFavor) {
        this.levelOfFavor = levelOfFavor;
    }

    public void setFavorInputOutput(String favorInputOutput) {
        this.favorInputOutput = favorInputOutput;
    }

    public static void findFavor() {
        Scanner sc = new Scanner(System.in);
        List<FavorObject> listOfFavors = favorObjectList;

        System.out.print("Write a name of the favor, which you want to find: ");
        String findingFavorInput = sc.nextLine();

        for (FavorObject favorObject : listOfFavors) {
            if (favorObject.getNameOfFavor().equals(findingFavorInput)) {
                System.out.println(findingFavorInput + " exists.\n");
                return;
            }
        }
        System.out.println(findingFavorInput + " doesn't exists.\n");
    }

    public static void createFavor() {
        Scanner sc = new Scanner(System.in);
        Contact contact = null;

        System.out.println("\n === Guide to create a new favor ===\n");
        System.out.print("Write name of the favor: ");
        String nameOfTheFavor = sc.nextLine();
        System.out.print("Write description: ");
        String description = sc.nextLine();
        System.out.print("Write last name of contact: ");
        String contactName = sc.nextLine().trim();

        boolean isNotChoosen = true;
        while (isNotChoosen) {
            for (Contact nameOfContact : contactList) {
                if (nameOfContact.getLastName().equals(contactName)) {
                    System.out.print("\nYou mean this contact? " + nameOfContact + "\n(y/n) ");
                    String answer = sc.nextLine().trim().toLowerCase();

                    if (answer.equals("y")) {
                        contact = nameOfContact;
                        isNotChoosen = false;
                        break;
                    }
                } else {
                    System.out.print("No contact found. Do you want to create a new one? (y/n) ");
                    String answer = sc.nextLine().trim().toLowerCase();
                    if (answer.equals("y")) {
                        contact = createContact();
                        isNotChoosen = false;
                        break;
                    } else if (answer.equals("n")) {
                        return;
                    } else {
                        System.out.print("\nWrong command.\n");
                    }
                }
            }
        }

        System.out.print("Write type of favor: ");
        String favorInputOutput = sc.nextLine();
        int levelOfFavorNew;
        while (true) {
            System.out.print("Write level of favor (number 1 to 3): ");
            try {
                int levelOfFavorInput = sc.nextInt();
                if (levelOfFavorInput > 0 && levelOfFavorInput < 4) {
                    levelOfFavorNew = levelOfFavorInput;
                    sc.nextLine();
                    break;
                } else {
                    System.out.print("This number is out of range!\n");
                }
            } catch (InputMismatchException e) {
                System.out.print("This is not a number!\n");
                sc.nextLine();
            }
        }

        System.out.print("\n === Your new Favor is ===" + "\nName of Favor: " + nameOfTheFavor + "\nDescription: " + description +
                "\nContact: " + contactName + "\nLevel of Favor: " + levelOfFavorNew + "\nFavor type: " + favorInputOutput + "\n");

        System.out.print("Do you want to save new favor? (y/n): ");
        String finalAnswer = sc.nextLine().toLowerCase().trim();

        if (finalAnswer.equals("y")) {
            FavorObject newFavorCreated = new FavorObject(nameOfTheFavor, description, contact, levelOfFavorNew, favorInputOutput);
            favorObjectList.add(newFavorCreated);
            System.out.println("\n=== New favor is ====" + newFavorCreated + "\n");
        } else if (finalAnswer.equals("n")) {
            System.out.print("\nYour new favor is not saved.\n");
        } else {
            System.out.print("\nWrong command.\n");
        }
    }

    public static void deleteFavor() {
        Scanner sc = new Scanner(System.in);
        int indexOfFavor;
        List<FavorObject> listOfFavors = favorObjectList;
        System.out.print("Which favor do you want to delete?: ");
        String favorToDelete = sc.nextLine();

        for (FavorObject favorObject : listOfFavors) {
            if (favorObject.getNameOfFavor().equals(favorToDelete)) {
                indexOfFavor = listOfFavors.indexOf(favorObject);
                favorObjectList.remove(indexOfFavor);
                System.out.println("Favor was deleted.\n");
                return;
            } else {
                System.out.println(favorToDelete + " doesn't exists.\n");
            }
        }
    }

    /**
     * This method delete all favors in database
     */
    public static void deleteAllFavors() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to delete all favors? (y/n): ");
        String answer = sc.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {
            favorObjectList.clear();
            System.out.println("\nAll favors was deleted.\n");
        } else if (answer.equals("n")) {
            System.out.println("You didn't want to clear all data.\n");
        } else {
            System.out.println("Wrong answer.\n");
        }
    }

    public static void editFavor() {
        Scanner sc = new Scanner(System.in);
        int indexOfFavor;
        List<FavorObject> listOfFavors = favorObjectList;
        System.out.print("Which favor do you want to edit? ");
        String favorToEdit = sc.nextLine();

        for (FavorObject favorObject : listOfFavors) {
            if (favorObject.getNameOfFavor().equals(favorToEdit)) {
                indexOfFavor = listOfFavors.indexOf(favorObject);
                System.out.print("What is your new value? ");
                String newValue = sc.nextLine();
                listOfFavors.get(indexOfFavor).setNameOfFavor(newValue);
                break;
            } else {
                System.out.println(favorToEdit + " doesn't exists.\n");
            }
        }
    }

    public static void showAllFavors() {
        Scanner sc = new Scanner(System.in);

        if (favorObjectList.isEmpty()) {
            System.out.println("\nNo data.\n");
            return;
        }

        System.out.print("\nDo you want to see all favors? (y/n): ");
        String answer = sc.nextLine();
        if (answer.equals("y")) {
            for (FavorObject object : favorObjectList) {
                System.out.println(object);
            }
        } else if (answer.equals("n")) {
            System.out.println("All right, you don't want to see all favors.\n");
        } else {
            System.out.println("\nWrong answer.\n");
        }
    }

    @Override
    public String toString() {
        return "\nName of favor: " + nameOfFavor + "\nDescription: " + description + "\nContact: " + contact +
                "\nLevel of favor: " + levelOfFavor + "\nInputOrOutput: " + favorInputOutput + "\nDate of create: " + dateTime + "\n";
    }
}
