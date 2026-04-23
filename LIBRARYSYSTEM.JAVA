import java.util.*;

// CREATE CLASS NAMED BOOK
class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

// CREATE CLASS NAMED USER
class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// CREATE CLASS NAMED LIBRARY
class Library {
    List<Book> books = new ArrayList<>();
    List<User> users = new ArrayList<>();
    Map<Integer, String> issuedBooks = new HashMap<>(); // bookId → userId
    //adds book into the library system
    void addBook(int id, String title, String author) {
        books.add(new Book(id, title, author));
        System.out.println("Book has been added to the system");
    }
    //
    void userregistration(int id, String name) {
        users.add(new User(id, name));
        System.out.println("User has been registered successfully!");
    }

    void issueBook(int bookId, int userId) {
        for (Book b : books) {
            if (b.id == bookId && !b.isIssued) {
                b.isIssued = true;
                String issueDate=java.time.LocalDate.now().toString();
                issuedBooks.put(bookId, userId+"|"+issueDate);
                System.out.println("Book issued to the user successfully!");
                return;
            }
        }
        System.out.println("sorry, Book not available!");
    }
    //returns the book to the library system
    void returnBook(int bookId) {
        if(!issuedBooks.containsKey(bookId)) {
            System.out.println("This book was not issued!");
            return;
        }
        String data=issuedBooks.get(bookId);
        String[] parts=data.split("\\|");
        String issueDatestr=parts[1];
        java.time.LocalDate issueDate=java.time.LocalDate.parse(issueDatestr);
        java.time.LocalDate returnDate=java.time.LocalDate.now();
        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(issueDate, returnDate);
        if(daysBetween>14) {
            long fine=(daysBetween-14)*5;
            System.out.println("Book returned with a fine of Rs."+fine);
        } else {
            System.out.println("Book returned successfully!");
        }
        for(Book b : books) {
            if(b.id==bookId) {
                b.isIssued=false;
                issuedBooks.remove(bookId);
                return;
            }
        }
    }

    void searchBook(String keyword) {
        for (Book b : books) {
            if (b.title.toLowerCase().contains(keyword.toLowerCase()) ||
                b.author.toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + b.title + " by " + b.author);
            }
        }
    }

    void displayBooks() {
        System.out.println("\nAvailable Books:");
        for (Book b : books) {
            System.out.println(b.id + " - " + b.title + " (" + (b.isIssued ? "Issued" : "Available") + ")");
        }
    }
}

// Main Class
public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib_sys = new Library();
        
        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Register User");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. Display Books");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    lib_sys.addBook(bid, title, author);
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int uid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    lib_sys.userregistration(uid, name);
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int issueId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    lib_sys.issueBook(issueId, userId);
                    break;

                case 4:
                    System.out.print("Enter Book ID: ");
                    int returnId = sc.nextInt();
                    lib_sys.returnBook(returnId);
                    break;

                case 5:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    lib_sys.searchBook(keyword);
                    break;

                case 6:
                    lib_sys.displayBooks();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}