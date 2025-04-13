class LibraryNode{

    String title;
    String author;
    String genre;
    int bookId;
    String availabilityStatus;
    LibraryNode next, prev;

    public LibraryNode(String title, String author, String genre, int bookId, String availabilityStatus) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.availabilityStatus = availabilityStatus;
        this.next = this.prev = null;
    }
}

class Library {

    LibraryNode head;

    public void addBeg(String title, String author, String genre, int bookId, String availabilityStatus) {
        LibraryNode book = new LibraryNode(title, author, genre, bookId, availabilityStatus);

        if (head == null) {
            head = book;
            return;
        }
        if (head.next == null) {
            book.next = head;
            head.prev = book;
            return;
        }
        head = book;
    }

    public void addEnd(String title, String author, String genre, int bookId, String availabilityStatus) {
        LibraryNode book = new LibraryNode(title, author, genre, bookId, availabilityStatus);

        if (head == null) {
            head = book;
            return;
        }

        LibraryNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = book;
        book.prev = temp;
    }

    public void addPos(String title, String author, String genre, int bookId, int pos, String availabilityStatus) {
        LibraryNode book = new LibraryNode(title, author, genre, bookId, availabilityStatus);
        if (head == null) {
            head = book;
            return;
        }

        if (pos == 1) {
            addBeg(title, author, genre, bookId, availabilityStatus);
            return;
        }

        LibraryNode temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }

        if (head.next == null) {
            addEnd(title, author, genre, bookId, availabilityStatus);
        } else {
            book.next = temp.next;
            book.prev = temp;
            temp.next.prev = book;
            temp.next = book;
        }
    }

    public void removeById(int id) {

        LibraryNode temp = head;

        if (head == null) {
            System.out.println("No Books found!");
            return;
        }

        if (head.next == null && !(head.bookId == id)) {
            System.out.println("Book Not found!");
            return;
        }

        while (temp != null) {
            if(temp.bookId == id) {
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                }
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                }
                return;
            }
            temp = temp.next;
        }
    }

    public void SearchByTitleOrAuthor(String keyWord) {

        LibraryNode temp = head;

        if (head == null) {
            System.out.println("No Books found!");
            return;
        }

        if (head.next == null && !(head.title.equalsIgnoreCase(keyWord) || (head.author.equalsIgnoreCase(keyWord)))) {
            System.out.println("Book Not found!");
            return;
        }

        while (temp.next != null) {
            if (temp.title.equalsIgnoreCase(keyWord) || temp.author.equalsIgnoreCase(keyWord)) {
                display(temp);
            }
            temp = temp.next;
        }
    }

    public void bookCount() {
        LibraryNode temp = head;
        int count = 0;
        if(head == null) {
            System.out.println("There is no book in the Library.");
        }

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        System.out.println("The total books in the Library are " + count);
    }

    public void updateAvailabilityStatus(int id, String status){
        LibraryNode temp = head;
        if(head == null) {
            System.out.println("Library has no books!");
            return;
        }

        if(head.next == null && ! (head.bookId == id)){
            System.out.println("Book Not Found!");
            return;
        }

        while (temp.next != null) {
            if(temp.bookId == id){
                temp.availabilityStatus = status;
            }
            temp = temp.next;
        }
    }

    public void display(LibraryNode book) {
        System.out.printf("%-17s %-20s %-10s %-10d %-10s\n", book.title, book.author, book.genre, book.bookId, book.availabilityStatus);
    }

    public void displayAllForward() {
        if (head == null) {
            System.out.println("No Movie Records found!.");
            return;
        }

        LibraryNode temp = head;

        System.out.println("==================================================================================");
        System.out.printf("%-17s %-20s %-10s %-10s %-10s\n", "Book Title", "Author", "Genre", "Book Id", "Availability Status");
        System.out.println("==================================================================================");
        while (temp != null) {
            display(temp);
            temp = temp.next;
        }
        System.out.println("==================================================================================");
    }

    public void displayAllBackward() {
        if (head == null) {
            System.out.println("No Movie Records found!.");
            return;
        }

        LibraryNode temp = head;

        System.out.println("==================================================================================");
        System.out.printf("%-17s %-20s %-10s %-10s %-10s\n", "Book Title", "Author", "Genre", "Book Id", "Availability Status");
        System.out.println("==================================================================================");
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            display(temp);
            temp = temp.prev;
        }
        System.out.println("==================================================================================");
    }
}

public class LibraryManagementSystem {

    public static void main(String[] args) {

        Library library = new Library();

        library.addBeg("The Alchemist", "Paulo Coelho", "Fiction", 101, "Available");
        library.addEnd("Sapiens", "Yuval Noah Harari", "History", 102, "Available");
        library.addEnd("1984", "George Orwell", "Dystopian", 103, "Available");
        library.addPos("Harry Potter", "J.K.Rowling", "Fantasy", 104, 2, "Available");

        library.displayAllForward();

        library.updateAvailabilityStatus(102, "Issued");

        System.out.println("\nAfter updating availability status:");
        library.displayAllForward();

        System.out.println("\nSearch result for 'George Orwell':");
        library.SearchByTitleOrAuthor("George Orwell");

        library.bookCount();

        library.removeById(103);

        System.out.println("\nAfter removing book ID 103:");
        library.displayAllForward();

        System.out.println("\nBooks in reverse order:");
        library.displayAllBackward();
    }
}
