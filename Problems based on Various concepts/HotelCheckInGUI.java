import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HotelGUI extends JFrame implements ActionListener {

    JTextField txtName, txtEmail, txtContact;
    JRadioButton rbMale, rbFemale;
    ButtonGroup genderGroup;
    JButton btnSubmit;

    public HotelGUI() {
        setTitle("HOTEL CHECK IN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15)); // more spacing between sections

        // === MAIN FORM PANEL ===
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 15, 15)); // bigger gaps between rows/cols
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 20, 40)); // top, left, bottom, right padding

        // Name
        formPanel.add(new JLabel("Name:"));
        txtName = new JTextField(20);
        formPanel.add(txtName);

        // Email
        formPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField(20);
        formPanel.add(txtEmail);

        // Contact Number
        formPanel.add(new JLabel("Contact Number:"));
        txtContact = new JTextField(20);
        formPanel.add(txtContact);

        // === GENDER PANEL BELOW ===
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10)); // horizontal + vertical gap
        genderPanel.setBorder(BorderFactory.createTitledBorder("Select Gender"));

        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");

        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);

        genderPanel.add(rbMale);
        genderPanel.add(rbFemale);

        // === SUBMIT BUTTON ===
        btnSubmit = new JButton("Submit");
        btnSubmit.setPreferredSize(new Dimension(100, 40)); // larger button
        btnSubmit.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        buttonPanel.add(btnSubmit);

        // === ADD TO FRAME ===
        add(formPanel, BorderLayout.NORTH);
        add(genderPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setSize(400, 350); // give a default comfortable window size
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    // === ACTION HANDLER ===
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String contact = txtContact.getText().trim();

        String gender = "";
        if (rbMale.isSelected()) gender = "Male";
        else if (rbFemale.isSelected()) gender = "Female";

        if (name.isEmpty() || email.isEmpty() || contact.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all the details!");
        } else {
            JOptionPane.showMessageDialog(this,
                    "Booking Confirmed!\n\n" +
                            "Name: " + name +
                            "\nEmail: " + email +
                            "\nContact No: " + contact +
                            "\nGender: " + gender);
        }
    }

    // === MAIN ===
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HotelGUI());
    }
}
