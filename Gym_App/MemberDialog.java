package Gym_App;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class MemberDialog extends JDialog {
    private JTextField tfName = new JTextField(20);
    private JTextField tfAge = new JTextField(4);
    private JTextField tfWeight = new JTextField(6);
    private JTextField tfHeight = new JTextField(6);
    private JComboBox<MembershipPlan> cbPlan = new JComboBox<>(MembershipPlan.values());
    private boolean succeeded = false;
    private Member member;

    public MemberDialog(Frame parent, Member m) {
        super(parent, (m==null?"Add Member":"Edit Member"), true);
        this.member = (m==null? new Member() : m);
        JPanel p = new JPanel(new GridLayout(0,2,6,6));
        p.add(new JLabel("Name:")); p.add(tfName);
        p.add(new JLabel("Age:")); p.add(tfAge);
        p.add(new JLabel("Weight (kg):")); p.add(tfWeight);
        p.add(new JLabel("Height (cm):")); p.add(tfHeight);
        p.add(new JLabel("Plan:")); p.add(cbPlan);

        if (m != null) {
            tfName.setText(m.getName());
            tfAge.setText(String.valueOf(m.getAge()));
            tfWeight.setText(String.valueOf(m.getWeightKg()));
            tfHeight.setText(String.valueOf(m.getHeightCm()));
            cbPlan.setSelectedItem(m.getPlan());
        }

    JButton btnOk = new JButton("Save");
    btnOk.setForeground(Color.BLACK);
    btnOk.setBackground(new Color(200, 230, 255));
    JButton btnCancel = new JButton("Cancel");
    btnCancel.setForeground(Color.BLACK);
    btnCancel.setBackground(new Color(230,230,230));
        btnOk.addActionListener(e -> {
            try {
                member.setName(tfName.getText().trim());
                member.setAge(Integer.parseInt(tfAge.getText().trim()));
                member.setWeightKg(Double.parseDouble(tfWeight.getText().trim()));
                member.setHeightCm(Double.parseDouble(tfHeight.getText().trim()));
                MembershipPlan plan = (MembershipPlan) cbPlan.getSelectedItem();
                member.setPlan(plan);
                member.setMembershipExpiry(plan.expiryFrom(LocalDate.now()));
                succeeded = true;
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(MemberDialog.this, "Please provide valid inputs", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        btnCancel.addActionListener(e -> { succeeded = false; dispose(); });

        JPanel bp = new JPanel(); bp.add(btnOk); bp.add(btnCancel);
        getContentPane().add(p, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
        p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        pack(); setResizable(false); setLocationRelativeTo(parent);
    }

    public boolean isSucceeded() { return succeeded; }
    public Member getMember() { return member; }
}
