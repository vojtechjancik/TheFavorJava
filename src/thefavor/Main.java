package thefavor;


import java.util.Scanner;

import static thefavor.Contact.*;
import static thefavor.DatabaseOfFavors.databaseFavors;
import static thefavor.FavorObject.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        databaseFavors();
        System.out.println("Welcome in The Favor app. Please write a command (If you don't know any commands, write help): ");

        while (true) {
            switch (sc.nextLine().toLowerCase().trim()) {
                case "help":
                    System.out.println("Commands are: " + HelperClass.commands() +"\n");
                    break;
                case "findfavor":
                    findFavor();
                    break;
                case "createfavor":
                    createFavor();
                    break;
                case "deletefavor":
                    deleteFavor();
                    break;
                case "editfavor":
                    editFavor();
                    break;
                case "showallfavors":
                    showAllFavors();
                    break;
                case "deleteallfavors":
                    deleteAllFavors();
                    break;
                case "createcontact":
                    createContact();
                    break;
                case "showallcontacts":
                    showAllContacts();
                    break;
                case "deleteallcontacts":
                    deleteAllContacts();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Wrong command.\n");
            }
            System.out.print("Which command do you want to use?: ");
        }
    }
}
