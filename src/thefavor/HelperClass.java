package thefavor;

import java.util.Arrays;
import java.util.List;

public class HelperClass {

    public static List<String> commands() {
        return Arrays.asList("help", "findFavor", "createFavor", "deleteFavor", "exit",
                "editFavor", "deleteAllFavors", "showAllFavors", "createContact", "showAllContacts",
                "deleteAllContacts");
    }
}
