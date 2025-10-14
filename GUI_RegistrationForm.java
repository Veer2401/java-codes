import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_RegistrationForm extends JFrame implements ActionListener {

    private JLabel lblName, lblEmail, lblAge, lblGender, lblDomain, lblTitle;
    private JTextField textName, textEmail, textAge, textDomain;
    private JRadioButton maleRadio, femaleRadio;
    private ButtonGroup genderGroup;
    private JButton btnRegister, btnClear;
    private JPanel mainPanel, formPanel, buttonPanel;

    public GUI_RegistrationForm() {
        
        setTitle("Google Event Registration");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setResizable(false);
        
        initializeComponents();
        setupLayout();
        applyStyles();
    }

    private void initializeComponents() {
        // Main panel with gradient background
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                // Gradient background
                GradientPaint gradient = new GradientPaint(0, 0, new Color(74, 144, 226), 
                                                         0, getHeight(), new Color(220, 231, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        
        // Form panel with rounded border
        formPanel = new JPanel();
        formPanel.setLayout(null);
        formPanel.setOpaque(false);
        
        // Title
        lblTitle = new JLabel("Event Registration", SwingConstants.CENTER);
        
        // Labels
        lblName = new JLabel("Full Name:");
        lblEmail = new JLabel("Email Address:");
        lblAge = new JLabel("Age:");
        lblGender = new JLabel("Gender:");
        lblDomain = new JLabel("Domain/Field:");

        // Text fields
        textName = new JTextField();
        textEmail = new JTextField();
        textAge = new JTextField();
        textDomain = new JTextField();

        // Radio buttons
        maleRadio = new JRadioButton("Male");
        femaleRadio = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        genderGroup.add(maleRadio);
        genderGroup.add(femaleRadio);

        // Buttons
        btnRegister = new JButton("Register Now");
        btnClear = new JButton("Clear Form");
        
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        buttonPanel.setOpaque(false);
    }

    private void setupLayout() {
        setLayout(new BorderLayout());
        
        // Title positioning
        lblTitle.setBounds(50, 30, 480, 40);
        
        // Form fields positioning with better spacing
        int yStart = 100;
        int fieldHeight = 35;
        int spacing = 50;
        
        lblName.setBounds(80, yStart, 120, 25);
        textName.setBounds(220, yStart, 260, fieldHeight);
        
        lblEmail.setBounds(80, yStart + spacing, 120, 25);
        textEmail.setBounds(220, yStart + spacing, 260, fieldHeight);
        
        lblAge.setBounds(80, yStart + spacing * 2, 120, 25);
        textAge.setBounds(220, yStart + spacing * 2, 260, fieldHeight);
        
        lblGender.setBounds(80, yStart + spacing * 3, 120, 25);
        maleRadio.setBounds(220, yStart + spacing * 3, 80, 25);
        femaleRadio.setBounds(320, yStart + spacing * 3, 80, 25);
        
        lblDomain.setBounds(80, yStart + spacing * 4, 120, 25);
        textDomain.setBounds(220, yStart + spacing * 4, 260, fieldHeight);
        
        // Button panel
        buttonPanel.setBounds(50, yStart + spacing * 5 + 20, 480, 50);
        buttonPanel.add(btnRegister);
        buttonPanel.add(btnClear);
        
        // Add components to form panel
        formPanel.add(lblTitle);
        formPanel.add(lblName);
        formPanel.add(textName);
        formPanel.add(lblEmail);
        formPanel.add(textEmail);
        formPanel.add(lblAge);
        formPanel.add(textAge);
        formPanel.add(lblGender);
        formPanel.add(maleRadio);
        formPanel.add(femaleRadio);
        formPanel.add(lblDomain);
        formPanel.add(textDomain);
        formPanel.add(buttonPanel);
        
        add(mainPanel, BorderLayout.CENTER);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.CENTER);
    }

    private void applyStyles() {
        // Title styling
        lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitle.setForeground(Color.WHITE);
        
        // Label styling
        Font labelFont = new Font("Segoe UI", Font.BOLD, 14);
        Color labelColor = new Color(51, 51, 51);
        
        JLabel[] labels = {lblName, lblEmail, lblAge, lblGender, lblDomain};
        for (JLabel label : labels) {
            label.setFont(labelFont);
            label.setForeground(labelColor);
        }
        
        // Text field styling
        JTextField[] textFields = {textName, textEmail, textAge, textDomain};
        for (JTextField field : textFields) {
            field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            field.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(new Color(200, 200, 200), 1, true),
                BorderFactory.createEmptyBorder(8, 12, 8, 12)
            ));
            field.setBackground(Color.WHITE);
            
            // Add focus effects
            field.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    field.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(74, 144, 226), 2, true),
                        BorderFactory.createEmptyBorder(7, 11, 7, 11)
                    ));
                }
                
                @Override
                public void focusLost(FocusEvent e) {
                    field.setBorder(BorderFactory.createCompoundBorder(
                        new LineBorder(new Color(200, 200, 200), 1, true),
                        BorderFactory.createEmptyBorder(8, 12, 8, 12)
                    ));
                }
            });
        }
        
        // Radio button styling
        maleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        femaleRadio.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        maleRadio.setOpaque(false);
        femaleRadio.setOpaque(false);
        maleRadio.setForeground(labelColor);
        femaleRadio.setForeground(labelColor);
        
        // Register button styling
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnRegister.setBackground(new Color(34, 139, 34));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setBorder(new RoundedBorder(10));
        btnRegister.setPreferredSize(new Dimension(150, 40));
        btnRegister.setFocusPainted(false);
        btnRegister.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Clear button styling
        btnClear.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnClear.setBackground(new Color(220, 53, 69));
        btnClear.setForeground(Color.WHITE);
        btnClear.setBorder(new RoundedBorder(10));
        btnClear.setPreferredSize(new Dimension(120, 40));
        btnClear.setFocusPainted(false);
        btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Add hover effects
        addHoverEffect(btnRegister, new Color(34, 139, 34), new Color(46, 160, 46));
        addHoverEffect(btnClear, new Color(220, 53, 69), new Color(240, 73, 89));
        
        // Add action listeners
        btnRegister.addActionListener(this);
        btnClear.addActionListener(e -> clearForm());
    }
    
    private void addHoverEffect(JButton button, Color normalColor, Color hoverColor) {
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(hoverColor);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(normalColor);
            }
        });
    }
    
    private void clearForm() {
        textName.setText("");
        textEmail.setText("");
        textAge.setText("");
        textDomain.setText("");
        genderGroup.clearSelection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = textName.getText().trim();
        String email = textEmail.getText().trim();
        String age = textAge.getText().trim();
        String domain = textDomain.getText().trim();

        String gender = "";
        if (maleRadio.isSelected()) {
            gender = "Male";
        } else if (femaleRadio.isSelected()) {
            gender = "Female";
        }

        if (name.isEmpty() || email.isEmpty() || age.isEmpty() || domain.isEmpty() || gender.isEmpty()) {
            showStyledMessage("Please fill in all fields!", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else if (!isValidEmail(email)) {
            showStyledMessage("Please enter a valid email address!", "Invalid Email", JOptionPane.ERROR_MESSAGE);
        } else {
            showStyledMessage(
                "<html><div style='text-align: center;'>" +
                "<h2 style='color: #228B22;'>Registration Successful!</h2>" +
                "<p><b>Name:</b> " + name + "</p>" +
                "<p><b>Email:</b> " + email + "</p>" +
                "<p><b>Age:</b> " + age + "</p>" +
                "<p><b>Gender:</b> " + gender + "</p>" +
                "<p><b>Domain:</b> " + domain + "</p>" +
                "<br><p style='color: #666;'>Thank you for registering with us!</p>" +
                "</div></html>",
                "Registration Complete",
                JOptionPane.INFORMATION_MESSAGE
            );
            clearForm();
        }
    }
    
    private boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
    
    private void showStyledMessage(String message, String title, int messageType) {
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    // Custom rounded border class
    class RoundedBorder implements Border {
        private int radius;
        
        RoundedBorder(int radius) {
            this.radius = radius;
        }
        
        public Insets getBorderInsets(Component c) {
            return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
        }
        
        public boolean isBorderOpaque() {
            return true;
        }
        
        public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GUI_RegistrationForm().setVisible(true);
        });
    }
}
