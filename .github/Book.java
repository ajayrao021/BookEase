public class Book {
    private String id;
    private String title;
    private String author;
    private int quantity;

    public Book(String id, String title, String author, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public void displayDetails() {
        System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Quantity: " + quantity);
    }
}

