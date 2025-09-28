
//java assignment 1
import java.util.Scanner;

class Books {
    int id;
    String title, author;
    boolean isAvail;

    public Books(int i, String t, String a) {

        id = i;
        title = t;
        author = a;
        isAvail = true;
    }
    public void display() {

        System.out.println("________________________________________________________");
        System.out.println("Id: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("________________________________________________________");
    }

}
public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);
    static Books[] books = new Books[100];
    static int BooksCount = 0;

    public static void main(String[] args) {

        int choice;
        System.out.println("LIBRARY MANAGEMENT SYSTEM");
        do {

            //System.out.println("-----------------------------------------");
            System.out.println("--------------- Menu --------------------");
            System.out.println("1. Add Book");
            System.out.println("2. Delete Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Books");
            System.out.println("7. Borrow Book");
            System.out.println("8. Exit");
            System.out.println("-----------------------------------------");


            System.out.print("Please Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> deleteBook();
                case 3 -> updateBook();
                case 4 -> searchBook();
                case 5 -> returnBook();
                case 6 -> displayBooks();
                case 7 -> borrowBook();
                case 8 -> System.out.println("Exiting.....");
                default -> System.out.println("Please enter a correct choice!");

            }

        } while (choice != 8);

        sc.close();

    }
    static void addBook() {

        System.out.print("Enter a book ID: ");

        int id = sc.nextInt();

        sc.nextLine();

        for (int i = 0; i < BooksCount; i++) {

            if (books[i].id == id) {

                System.out.println("Book with this ID already exists!");

                return;

            }

        }
        System.out.print("Enter book Title: ");

        String title = sc.nextLine();



        System.out.print("Enter author: ");

        String author = sc.nextLine();



        books[BooksCount] = new Books(id, title, author);

        BooksCount++;

        System.out.println("Book added successfully.");

        books[BooksCount - 1].display();

    }



    static void deleteBook() {

        if (BooksCount == 0) {

            System.out.println("No books to delete!");

            return;

        }

        System.out.print("Enter a book ID to delete: ");

        int id = sc.nextInt();

        sc.nextLine();
        int index = -1;

        for (int i = 0; i < BooksCount; i++) {

            if (books[i].id == id) {

                index = i;

                break;

            }

        }
        if (index == -1) {

            System.out.println("Book with ID " + id + " not found!");

        } else {

            for (int i = index; i < BooksCount - 1; i++) {

                books[i] = books[i + 1];

            }

            books[BooksCount - 1] = null;

            BooksCount--;

            System.out.println("Book deleted successfully.");
        }

    }

    static void updateBook(){

        System.out.println("Enter a book ID to update: ");

        int id = sc.nextInt();

        sc.nextLine();
        boolean found = false;

        for(int i=0;i<BooksCount;i++){

            if(books[i].id == id){

                System.out.println("Enter the new title: ");

                String newTitle = sc.nextLine();

                System.out.println("Enter new author: ");

                String newAuthor = sc.nextLine();
                books[i].title = newTitle;
                books[i].author = newAuthor;
                System.out.println("Book updated successfully");

                books[i].display();

                found = true;
                 break;

            }

        }

        if(!found){

            System.out.println("Book with ID " + id + " was not found!");
        }

    }
    static void searchBook(){

        System.out.println("Enter book title or author to search: ");

        String searchWord = sc.nextLine().toLowerCase();

        boolean found = false;
        for(int i=0;i<BooksCount;i++){

            if(books[i].title.toLowerCase().contains(searchWord) || books[i].author.toLowerCase().contains(searchWord)){

                books[i].display();

                found = true;

            }
        }

        if(!found){

            System.out.println("No books found with " + searchWord);
        }
    }
    static void borrowBook(){
        if(BooksCount == 0){
            System.out.println("No book available to borrow!");
        }
        System.out.println("Enter book ID to borrow");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;
        for(int i=0;i<BooksCount;i++){
            if(books[i].id == id){
                found = true;
                if(books[i].isAvail){
                    books[i].isAvail = false;
                    System.out.println("Book with ID: " + id + " borrowed successfully");
                    books[i].display();
                } else {
                    System.out.println("Book with ID: " + id + " is already borrowed.");
                }
                break;
            }
        }
        if(!found){
            System.out.println("Book with ID " + id + " not found!");
        }
    }
    static void returnBook(){
        System.out.println("Enter book ID to mark as returned: ");
        int id = sc.nextInt();
        sc.nextLine();
        boolean found = false;

        for(int i=0;i<BooksCount;i++){

            if(books[i].id == id){

                books[i].isAvail = true;

                System.out.println("Book ID " + id + " marked as available");

                found = true;
                System.out.println("Book with ID " + id + " is now available");

                break;
            }
        }

        if(!found){

            System.out.println("Book with ID " + id + " not found!");
        }

    }

    static void displayBooks(){

        System.out.println("List of Books:");

        for(int i=0;i<BooksCount;i++){

            books[i].display();
        }

        if(BooksCount == 0){

            System.out.println("No books available!");

            return;
        }

    }
}
