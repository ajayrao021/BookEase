import java.time.LocalDate;

public class IssueRecord {
    private String bookId;
    private String studentId;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public IssueRecord(String bookId, String studentId) {
        this.bookId = bookId;
        this.studentId = studentId;
        this.issueDate = LocalDate.now();
        this.returnDate = null;
    }

    public String getBookId() { return bookId; }
    public String getStudentId() { return studentId; }
    public LocalDate getReturnDate() { return returnDate; }

    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public void displayRecord() {
        System.out.println("Book ID: " + bookId + ", Student ID: " + studentId + ", Issued: " + issueDate + ", Returned: " + (returnDate != null ? returnDate : "Not returned"));
    }
}
