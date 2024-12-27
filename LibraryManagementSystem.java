import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class book {
    private String title;
    private String author;

    public book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}

class library {
    private List<Book> books;

    public library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public List<Book> getAllBooks() {
        return books;
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        library library = new library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Add a book");
            System.out.println("2. View all books");
            System.out.println("3. Search book by title");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 2:
                    List<Book> books = library.getAllBooks();
                    if (books.isEmpty()) {
                        System.out.println("No books available.");
                    } else {
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String searchTitle = scanner.nextLine();
                    Book book = library.searchBookByTitle(searchTitle);
                    if (book != null) {
                        System.out.println("Found: " + book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
