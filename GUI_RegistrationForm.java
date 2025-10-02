import javax.swing.*;
import java.awt.event.*;

public class GUI_RegistrationForm extends JFrame implements ActionListener {

    private JLabel lblName, lblEmail, lblAge, lblGender, lblDomain;
    private JTextField textName, textEmail, textAge, textDomain;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    private JButton btnRegister;

    public GUI_RegistrationForm() {
        
        setTitle("Google Event Registration");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  
        
        lblName = new JLabel("Name:");
        lblName.setBounds(30, 30, 100, 25);
        add(lblName);

        textName = new JTextField();
        textName.setBounds(140, 30, 200, 25);
        add(textName);

        
        lblEmail = new JLabel("Email:");
        lblEmail.setBounds(30, 70, 100, 25);
        add(lblEmail);

        textEmail = new JTextField();
        textEmail.setBounds(140, 70, 200, 25);
        add(textEmail);

        
        lblAge = new JLabel("Age:");
        lblAge.setBounds(30, 110, 100, 25);
        add(lblAge);

        textAge = new JTextField();
        textAge.setBounds(140, 110, 200, 25);
        add(textAge);

   
        lblGender = new JLabel("Gender:");
        lblGender.setBounds(30, 150, 100, 25);
        add(lblGender);

        maleRadio = new JRadioButton("Male");
        maleRadio.setBounds(140, 150, 80, 25);
        femaleRadio = new JRadioButton("Female");
        femaleRadio.setBounds(220, 150, 80, 25);

       
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        add(maleRadio);
        add(femaleRadio);

      
        lblDomain = new JLabel("Domain:");
        lblDomain.setBounds(30, 190, 100, 25);
        add(lblDomain);

        textDomain = new JTextField();
        textDomain.setBounds(140, 190, 200, 25);
        add(textDomain);

      
        btnRegister = new JButton("Register");
        btnRegister.setBounds(150, 240, 120, 30);
        add(btnRegister);

      
        btnRegister.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textName.getText();
        String email = textEmail.getText();
        String age = textAge.getText();
        String domain = textDomain.getText();

        String gender = "";
        if (maleRadio.isSelected()) {
            gender = "Male";
        } else if (femaleRadio.isSelected()) {
            gender = "Female";
        }

        if (name.isEmpty() || email.isEmpty() || age.isEmpty() || domain.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                "Please enter all the details!",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "Thank you for registering!\n"
                + "Name: " + name + "\n"
                + "Email: " + email + "\n"
                + "Age: " + age + "\n"
                + "Gender: " + gender + "\n"
                + "Domain: " + domain,
                "Registration Successful",
                JOptionPane.INFORMATION_MESSAGE);

           
            textName.setText("");
            textEmail.setText("");
            textAge.setText("");
            textDomain.setText("");
            genderGroup.clearSelection();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI_RegistrationForm().setVisible(true);
        });
    }
}
