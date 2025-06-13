import java.util.Scanner;

public class Login {
    public static boolean authenticate(String username, String password) {
        return username.equals("admin") && password.equals("admin123");
    }
}

// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Librarian librarian = new Librarian();

        System.out.println("--- Library Management System ---");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (Login.authenticate(username, password)) {
            System.out.println("Login Successful.\n");
            int choice;
            do {
                System.out.println("1. Add Book\n2. Show Books\n3. Issue Book\n4. Return Book\n5. Show Records\n0. Exit");
                System.out.print("Enter choice: ");
                while (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.next();
                }
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Quantity: ");
                        int qty = sc.nextInt(); sc.nextLine();
                        librarian.addBook(new Book(id, title, author, qty));
                        break;
                    case 2:
                        librarian.showBooks();
                        break;
                    case 3:
                        System.out.print("Book ID: ");
                        String bid = sc.nextLine();
                        System.out.print("Student ID: ");
                        String sid = sc.nextLine();
                        librarian.issueBook(bid, sid);
                        break;
                    case 4:
                        System.out.print("Book ID: ");
                        String rid = sc.nextLine();
                        System.out.print("Student ID: ");
                        String rsid = sc.nextLine();
                        librarian.returnBook(rid, rsid);
                        break;
                    case 5:
                        librarian.showRecords();
                        break;
                    case 0:
                        System.out.println("Exiting application.");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } while (choice != 0);
        } else {
            System.out.println("Invalid credentials. Exiting application.");
        }

        sc.close();
    }
}
