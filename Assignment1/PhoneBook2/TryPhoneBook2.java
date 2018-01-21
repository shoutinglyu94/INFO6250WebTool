
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class TryPhoneBook2 {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();                                  // The phone book
        FormattedInput in = new FormattedInput();                          // Keyboard input

        while (true) {
            System.out.println("Enter 1 to enter a new phone book entry\n"
                    + "Enter 2 to find the number for a surname\n"
                    + "Enter 3 to list all the entries\n"
                    + "Enter 9 to quit.");
            int what = 0;                                                    // Stores input selection
            try {
                what = in.readInt();

            } catch (InvalidUserInputException e) {
                System.out.println(e.getMessage() + "\nTry again.");
                continue;
            }

            switch (what) {
                case 1:
                    book.addEntry(BookEntry.readEntry());
                    break;
                case 2:
                    String someSurname = null;
                    try {
                        System.out.print("Enter surname: ");
                        someSurname = keyboard.readLine().trim();
                    } catch (IOException e) {
                        System.err.println("Error reading a name.");
                        e.printStackTrace();
                        System.exit(1);
                    }
                    LinkedList<BookEntry> surnameEntry = book.getEntryList(someSurname);
                    for(BookEntry be : surnameEntry){
                        System.out.println(be);
                    }
                    break;
                case 3:
                    book.listEntries();
                    break;
                case 9:
                    book.save();
                    System.out.println("Ending program.");
                    return;
                default:
                    System.out.println("Invalid selection, try again.");
                    break;
            }
        }
    }

    private static BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
}
