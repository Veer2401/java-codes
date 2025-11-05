package Gym_App;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * A more aesthetic admin-only login dialog.
 */
public class LoginDialog extends JDialog {
    private JTextField tfUser;
    private JPasswordField pfPassword;
    private boolean succeeded;
    private String role = "Admin";

    public LoginDialog(Frame parent) {
        super(parent, "Admin Login", true);
        setUndecorated(true);

        // Main gradient background panel
        JPanel background = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                Color c1 = new Color(58,123,213);
                Color c2 = new Color(58,96,115);
                GradientPaint gp = new GradientPaint(0,0,c1,0,getHeight(),c2);
                g2.setPaint(gp);
                g2.fillRect(0,0,getWidth(),getHeight());
            }
        };
        background.setLayout(new GridBagLayout());

        JPanel card = new JPanel(new GridBagLayout());
        card.setOpaque(false);
        card.setBorder(new EmptyBorder(18,18,18,18));

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(255,255,255,230));
        form.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200,200,200,150)),
                BorderFactory.createEmptyBorder(12,12,12,12)));

        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(6,6,6,6);
        c.gridx = 0; c.gridy = 0; c.gridwidth = 2; c.anchor = GridBagConstraints.CENTER;
        JLabel title = new JLabel("Gym Admin Portal");
        title.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        form.add(title, c);

        c.gridwidth = 1; c.anchor = GridBagConstraints.WEST;
        c.gridy++;
        form.add(new JLabel("Username"), c);
        tfUser = new JTextField(18);
        c.gridx = 1; form.add(tfUser, c);

        c.gridx = 0; c.gridy++; form.add(new JLabel("Password"), c);
        pfPassword = new JPasswordField(18);
        c.gridx = 1; form.add(pfPassword, c);

        // Login/Cancel buttons with styling
        c.gridx = 0; c.gridy++; c.gridwidth = 2; c.anchor = GridBagConstraints.CENTER;
        JPanel btns = new JPanel(); btns.setOpaque(false);
        JButton btnLogin = new JButton("Sign in");
    btnLogin.setBackground(new Color(58,123,213)); btnLogin.setForeground(Color.BLACK);
        btnLogin.setFocusPainted(false);
        JButton btnCancel = new JButton("Cancel");
    btnCancel.setBackground(new Color(230,230,230));
    btnCancel.setForeground(Color.BLACK);
    btnCancel.setFocusPainted(false);
        btns.add(btnLogin); btns.add(btnCancel);
        form.add(btns, c);

        // small note
        c.gridy++; JLabel note = new JLabel("Admin only. Contact your system administrator for credentials.");
        note.setFont(note.getFont().deriveFont(Font.ITALIC, 10f));
        form.add(note, c);

        // Put form into rounded white card
        card.add(form);
        background.add(card);

        getContentPane().add(background);

        // Buttons actions: accept only admin/admin
        btnLogin.addActionListener((ActionEvent e) -> {
            String user = tfUser.getText().trim();
            String pass = new String(pfPassword.getPassword());
            if (user.equals("admin") && pass.equals("admin")) {
                succeeded = true; role = "Admin"; dispose();
            } else {
                JOptionPane.showMessageDialog(LoginDialog.this, "Invalid admin credentials", "Login Failed", JOptionPane.ERROR_MESSAGE);
                tfUser.setText(""); pfPassword.setText(""); tfUser.requestFocusInWindow();
            }
        });

        btnCancel.addActionListener(e -> { succeeded = false; dispose(); });

        pack();
        setSize(420,260);
        setLocationRelativeTo(parent);
    }

    public boolean isSucceeded() { return succeeded; }
    public String getRole() { return role; }
}
