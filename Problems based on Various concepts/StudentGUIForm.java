
import javax.swing.*;
import java.awt.event.*;

public class StudentGUIForm extends JFrame implements ActionListener{

    JLabel lblName , lblAge , lblCourse;
    JTextField txtName, txtAge, txtCourse;
    JButton btnSubmit;

    public StudentGUIForm(){
        setTitle("Student Registration Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        lblName = new JLabel("Name: ");
        lblAge = new JLabel("Age: ");
        lblCourse = new JLabel("Course name: ");

        txtName = new JTextField();
        txtAge = new JTextField();
        txtCourse = new JTextField();

        btnSubmit = new JButton("Submit");

        lblName.setBounds(30,30,80,25);
        txtName.setBounds(120,30,150,25);

        lblAge.setBounds(30, 70, 80, 25);
        txtAge.setBounds(120, 70, 150, 25);

        lblCourse.setBounds(30, 130, 110, 25);
        txtCourse.setBounds(120, 130, 150, 25);

        btnSubmit.setBounds(100, 160, 100, 30);

        add(lblName); add(txtName);
        add(lblAge); add(txtAge);
        add(lblCourse); add(txtCourse);
        add(btnSubmit);

        btnSubmit.addActionListener(this);

        setSize(600,600);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e){
        String name = txtName.getText().trim();
        String age = txtAge.getText().trim();
        String course = txtCourse.getText().trim();

        if(name.isEmpty() || age.isEmpty() || course.isEmpty()){
            JOptionPane.showMessageDialog(this,"Please fill all the details!");
            return;
        }

        JOptionPane.showMessageDialog(this, "Registration Successful!\nName: " + name + "\nAge: " + age + "\nCourse: " + course);

    }

    public static void main(String[] args) {
        new StudentGUIForm();
    }
    
}