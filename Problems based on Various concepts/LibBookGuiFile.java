import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;


public class LibBookGuiFile extends JFrame implements ActionListener{

    JTextField searchField;
    JTextArea resultArea;
    JButton searchBtn;

    public LibBookGuiFile(){
        setTitle("Library Book Search");
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        getContentPane().setBackground(new Color(230, 240, 250));

        createBookFile();

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Enter Book Name: "));
        topPanel.setBackground(new Color(100,149,237));
        searchField = new JTextField(20);
        topPanel.add(searchField);

        searchBtn = new JButton("Search");
        searchBtn.addActionListener(this);
        searchBtn.setBackground(new Color(72, 61, 139)); 
        searchBtn.setForeground(Color.BLACK);
        searchBtn.setFocusPainted(false);
        searchBtn.setFont(new Font("Arial", Font.BOLD, 14));
        topPanel.add(searchBtn);

        add(topPanel,BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setBackground(new Color(245,245,245));
        resultArea.setFont(new Font("Serif",Font.PLAIN, 18));
        resultArea.setMargin(new Insets(10,10,10,10));
        add(new JScrollPane(resultArea),BorderLayout.CENTER);

        setVisible(true);
    }

    private void createBookFile(){
        File file = new File("/Users/veer/desktop/books.txt");
        if(!file.exists()){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write("Java Programming by James Gosling\n");
                writer.write("Effective Java by Joshua Bloch\n");
                writer.write("Introduction to Algorithms by Cormen\n");
                writer.write("Clean Code by Robert C. Martin\n");
                writer.write("The Art of Computer Programming by Donald Knuth\n");
                writer.write("Data Structures in Java by Mark Allen Weiss\n");
                writer.close();
                System.out.println("Books file created!");
            }catch(IOException e){
                System.out.println("Erro creating the file!");
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String searchTerm = searchField.getText().trim();
        resultArea.setText("");

        if(searchTerm.isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter A book name to Search!");
            return;
        }

        boolean found = false;

        try{
            BufferedReader r = new BufferedReader(new FileReader("/Users/veer/desktop/books.txt"));
            String line;

            while((line = r.readLine()) != null){
                if(line.toLowerCase().contains(searchTerm.toLowerCase())){
                    resultArea.append(line + "\n");
                    found = true;
                }
            }
            r.close();

            if(!found){
                resultArea.setText("No matching found for: " + searchTerm);
            }
        }catch(IOException ex){
            resultArea.setText("Error reading file " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        new LibBookGuiFile();
    }
}
