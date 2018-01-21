
import java.util.Collection;

public class TryPhoneBook2 {

    public static void main(String[] args) {
        PhoneBook book = new PhoneBook();                                  // The phone book
        FormattedInput in = new FormattedInput();                          // Keyboard input
        Person someone;
        PhoneNumber someNumber;
        while (true) {
            System.out.println("Enter 1 to enter a new phone book entry\n"
                    + "Enter 2 to find the number for a name\n"
                    + "Enter 3 to list all the entries\n"
                    + "Enter 4 to find the name for a number\n"
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
                    someone = Person.readPerson();
                    BookEntry entry = book.getEntry(someone);
                    if (entry == null) {
                        System.out.println("The number for " + someone + " was not found.");
                    } else {
                        System.out.println("The number for " + someone + " is " + entry.getNumber());
                    }
                    break;
                case 3:
                    book.listEntries();
                    break;
                case 4:
                    someNumber = PhoneNumber.readNumber();
                    BookEntry entry2 = book.getEntry(someNumber);
                    if(entry2 == null){
                        System.out.println("The person for " + someNumber + " was not found.");
                    }else{
                        System.out.println("The person for " + someNumber + " is " + entry2.getPerson() + " .");
                    }
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
}
