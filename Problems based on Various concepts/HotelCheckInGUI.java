import javax.swing.*;
import java.awt.event.*;

public class HotelCheckInGUI extends JFrame implements ActionListener {

    JLabel lblName, lblEmail, lblContactNumber;
    JTextField txtName, txtEmail, txtContactNumber;
    JButton btnSubmit;

    public HotelCheckInGUI(){
        setTitle("Hotel Check In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblName = new JLabel("Name: ");
        lblEmail = new JLabel("Email: ");
        lblContactNumber = new JLabel("Contact No: ");

        txtName = new JTextField();
        txtEmail = new JTextField();
        txtContactNumber = new JTextField();

        btnSubmit = new JButton("Submit");

        lblName.setBounds(30, 30, 80, 25);
        txtName.setBounds(120, 30, 150, 25);

        lblEmail.setBounds(30, 70, 80, 25);
        txtEmail.setBounds(120, 70, 150, 25);

        lblContactNumber.setBounds(30, 110, 110, 25);
        txtContactNumber.setBounds(140, 110, 150, 25);

        btnSubmit.setBounds(100, 160, 100, 30);

        add(lblName); add(txtName);
        add(lblEmail); add(txtEmail);
        add(lblContactNumber); add(txtContactNumber);
        add(btnSubmit);

        btnSubmit.addActionListener(this);

        setSize(600,600);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        String name = txtName.getText().trim();
        String email = txtEmail.getText().trim();
        String contact = txtContactNumber.getText().trim();

        if(name.isEmpty() || email.isEmpty() || contact.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please fill all the details!");
            return;
        }

        JOptionPane.showMessageDialog(this, 
        "Booking Confirmed!\n\n" +
        "Name: " + name + 
        "\nEmail: " + email + 
        "\nContact No: " + contact);
    }

    public static void main(String[] args) {
        new HotelCheckInGUI();
    }

    
}
