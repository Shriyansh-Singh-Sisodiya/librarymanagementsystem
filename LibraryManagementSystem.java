import java.util.Scanner;

class Book {
    String title;
    String author;
    boolean isAvailable;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

class Library {
    private static final int MAX_BOOKS = 100;
    private Book[] books;
    private int numBooks;

    Library() {
        books = new Book[MAX_BOOKS];
        numBooks = 0;
    }

    void addBook(String title, String author) {
        if (numBooks < MAX_BOOKS) {
            books[numBooks] = new Book(title, author);
            numBooks++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Library is full. Cannot add more books.");
        }
    }

    void displayBooks() {
        if (numBooks == 0) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (int i = 0; i < numBooks; i++) {
                System.out.println(i + 1 + ". " + books[i].title + " by " + books[i].author +
                        (books[i].isAvailable ? " (Available)" : " (Not Available)"));
            }
        }
    }

    void borrowBook(int bookIndex) {
        if (bookIndex >= 0 && bookIndex < numBooks) {
            if (books[bookIndex].isAvailable) {
                books[bookIndex].isAvailable = false;
                System.out.println("Book borrowed successfully.");
            } else {
                System.out.println("Book is not available for borrowing.");
            }
        } else {
            System.out.println("Invalid book index.");
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Add a Book");
            System.out.println("2. Display Books");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    library.addBook(title, author);
                    break;

                case 2:
                    library.displayBooks();
                    break;

                case 3:
                    library.displayBooks();
                    System.out.print("Enter the index of the book you want to borrow: ");
                    int bookIndex = scanner.nextInt();
                    library.borrowBook(bookIndex - 1); // Adjusting for 0-based index
                    break;

                case 4:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
