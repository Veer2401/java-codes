import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LibrarySearchGUI extends JFrame implements ActionListener {

    private JTextField bookName;
    private JTextField authorName;
    private JTextArea result;
    private JButton btnSearch;

    private ArrayList<Book> books;

    public LibrarySearchGUI() {
        setTitle("Book Search");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        books = new ArrayList<>();
        loadSampleBooks();

        JPanel inputPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel bookNameLabel = new JLabel("Book name:");
        bookName = new JTextField();

        JLabel authorLabel = new JLabel("Author:");
        authorName = new JTextField();

        btnSearch = new JButton("Search");
        btnSearch.addActionListener(this);

        inputPanel.add(bookNameLabel);
        inputPanel.add(bookName);
        inputPanel.add(authorLabel);
        inputPanel.add(authorName);
        inputPanel.add(new JLabel()); // empty cell
        inputPanel.add(btnSearch);

        result = new JTextArea();
        result.setEditable(false);
        result.setLineWrap(true);
        result.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(result);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void loadSampleBooks() {
        books.add(new Book("Introduction to Java", "Oracle"));
        books.add(new Book("Advanced Java", "Jane Smith"));
        books.add(new Book("Data Structures in C", "Mark Wilson"));
        books.add(new Book("Python for Beginners", "Alice Brown"));
        books.add(new Book("Java Swing Basics", "John Doe"));
        books.add(new Book("Database Management", "Robert Green"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {
            String book = bookName.getText().trim().toLowerCase();
            String author = authorName.getText().trim().toLowerCase();

            result.setText("");

            if (book.isEmpty() && author.isEmpty()) {
                result.setText("Please enter details to search!");
                return;
            }

            ArrayList<Book> results = new ArrayList<>();
            for (Book b : books) {
                boolean matchBook = b.getTitle().toLowerCase().contains(book);
                boolean matchAuthor = b.getAuthor().toLowerCase().contains(author);

                if ((book.isEmpty() || matchBook) && (author.isEmpty() || matchAuthor)) {
                    results.add(b);
                }
            }

            if (results.isEmpty()) {
                result.setText("No books found!");
            } else {
                result.append("Search Results:\n\n");
                for (Book b : results) {
                    result.append("- " + b.getTitle() + " by " + b.getAuthor() + "\n");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibrarySearchGUI().setVisible(true));
    }
}

// Custom Book class
class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}
