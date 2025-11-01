import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalc extends JFrame implements ActionListener {

    JTextField text;
    JButton[] numButtons = new JButton[10];
    JButton add, sub, mul, div, eq, clr;
    JPanel panel;

    int num1, num2, result;
    char operator;

    SimpleCalc() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        text = new JTextField();
        text.setBounds(30, 30, 220, 40);
        text.setEditable(false);
        add(text);

        add = new JButton("+");
        sub = new JButton("-");
        mul = new JButton("*");
        div = new JButton("/");
        eq = new JButton("=");
        clr = new JButton("C");

        // Create number buttons 0–9
        for (int i = 0; i < 10; i++) {
            numButtons[i] = new JButton(String.valueOf(i));
            numButtons[i].addActionListener(this);
        }

        // Add all buttons to a panel with grid layout
        panel = new JPanel();
        panel.setBounds(30, 90, 220, 220);
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Arrange buttons like a real calculator
        panel.add(numButtons[7]);
        panel.add(numButtons[8]);
        panel.add(numButtons[9]);
        panel.add(add);

        panel.add(numButtons[4]);
        panel.add(numButtons[5]);
        panel.add(numButtons[6]);
        panel.add(sub);

        panel.add(numButtons[1]);
        panel.add(numButtons[2]);
        panel.add(numButtons[3]);
        panel.add(mul);

        panel.add(numButtons[0]);
        panel.add(clr);
        panel.add(eq);
        panel.add(div);

        add(panel);

        // Add listeners
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        eq.addActionListener(this);
        clr.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        // Number buttons
        for (int i = 0; i < 10; i++) {
            if (src == numButtons[i]) {
                text.setText(text.getText() + i);
            }
        }

        // Operator buttons
        if (src == add) { num1 = Integer.valueOf(text.getText()); operator = '+'; text.setText(""); }
        if (src == sub) { num1 = Integer.valueOf(text.getText()); operator = '-'; text.setText(""); }
        if (src == mul) { num1 = Integer.valueOf(text.getText()); operator = '*'; text.setText(""); }
        if (src == div) { num1 = Integer.valueOf(text.getText()); operator = '/'; text.setText(""); }

        // Equals button
        if (src == eq) {
            num2 = Integer.valueOf(text.getText());
            switch (operator) {
                case '+': result = num1 + num2; break;
                case '-': result = num1 - num2; break;
                case '*': result = num1 * num2; break;
                case '/':
                    if (num2 == 0) {
                        text.setText("Err");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            text.setText(String.valueOf(result));
        }

        // Clear button
        if (src == clr) {
            text.setText("");
        }
    }

    public static void main(String[] args) {
        new SimpleCalc();
    }
}
