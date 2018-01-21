
import java.nio.file.*;
import java.io.*;
import java.util.*;

class PhoneBook implements Serializable {
    // List all entries in the book

    public void listEntries() {
        // Get the entries as a linked list
        LinkedList<BookEntry> entries = new LinkedList<>(phonebook.values());
        Collections.sort(entries);                                         // Sort the entries

        for (BookEntry entry : entries) {
            System.out.println(entry);
        }
    }

    @SuppressWarnings("unchecked")
    public PhoneBook() {
        if (Files.exists(file)) {                                           // If there's a phone book in a file...
            try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(file)))) {
                phonebook = (HashMap<Person, BookEntry>) in.readObject();       //...read it in.
                surnamebook = (HashMap<String, LinkedList<BookEntry>>) in.readObject();
            } catch (ClassNotFoundException | IOException e) {
                e.printStackTrace();
                System.exit(1);
            }
        }
    }

    public void save() {
        try {
            Files.createDirectories(file.getParent());                       // Make sure we have the directory
        } catch (IOException e) {
            System.err.println("I/O error creating directory. " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
        try (ObjectOutputStream out = new ObjectOutputStream(
                new BufferedOutputStream(Files.newOutputStream(file)))) {
            System.out.println("Saving phone book");
            out.writeObject(phonebook);
            out.writeObject(surnamebook);
            System.out.println("Done");
        } catch (IOException e) {
            System.out.println("I/O error saving phone book. " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void addEntry(BookEntry entry) {
        phonebook.put(entry.getPerson(), entry);
        
        if (surnamebook.get(entry.getPerson().getSurname()) == null) {          //Add and update entry into surnamebook
            LinkedList<BookEntry> surnameEntryList = new LinkedList<>();
            surnameEntryList.add(entry);
            surnamebook.put(entry.getPerson().getSurname(), surnameEntryList);
        } else {
            LinkedList<BookEntry> surnameEntryList = surnamebook.get(entry.getPerson().getSurname());
            surnameEntryList.add(entry);
        }
    }

    public BookEntry getEntry(Person key) {
        return phonebook.get(key);
    }

    public LinkedList<BookEntry> getEntryList(String surname) {
        return surnamebook.get(surname);
    }

    public PhoneNumber getNumber(Person key) {
        BookEntry entry = getEntry(key);
        if (entry != null) {
            return entry.getNumber();
        } else {
            return null;
        }
    }

    private HashMap<Person, BookEntry> phonebook = new HashMap<>();
    private HashMap<String, LinkedList<BookEntry>> surnamebook = new HashMap();
    private static final long serialVersionUID = 1001L;
    private Path file = Paths.get(System.getProperty("user.home")).resolve("Beginning Java Stuff").resolve("Phonebook.bin");
}
