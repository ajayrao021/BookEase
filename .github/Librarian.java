import java.util.*;

public class Librarian {
    private Map<String, Book> books = new HashMap<>();
    private List<IssueRecord> records = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("Book added successfully.");
    }

    public void issueBook(String bookId, String studentId) {
        Book book = books.get(bookId);
        if (book != null && book.isAvailable()) {
            book.setQuantity(book.getQuantity() - 1);
            records.add(new IssueRecord(bookId, studentId));
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(String bookId, String studentId) {
        for (IssueRecord record : records) {
            if (record.getBookId().equals(bookId) && record.getStudentId().equals(studentId) && record.getReturnDate() == null) {
                record.returnBook();
                books.get(bookId).setQuantity(books.get(bookId).getQuantity() + 1);
                System.out.println("Book returned successfully.");
                return;
            }
        }
        System.out.println("No matching issue record found.");
    }

    public void showBooks() {
        for (Book book : books.values()) {
            book.displayDetails();
        }
    }

    public void showRecords() {
        for (IssueRecord record : records) {
            record.displayRecord();
        }
    }
}

