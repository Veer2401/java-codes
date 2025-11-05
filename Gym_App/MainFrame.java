package Gym_App;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class MainFrame extends JFrame {
    private String role;
    private DataStore store;

    public MainFrame(String role) {
        super("Gym Management System - " + role);
        this.role = role;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,600);

        // load data
        store = DataStore.load();

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Dashboard", createDashboardPanel());
        tabs.addTab("Members", createMembersPanel());
        tabs.addTab("Trainers", createTrainersPanel());
        tabs.addTab("Payments", createPaymentsPanel());

        getContentPane().add(tabs, BorderLayout.CENTER);

        // Save on close
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                DataStore.save();
            }
        });
    }

    private JPanel createDashboardPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JPanel top = new JPanel(new GridLayout(1,3,10,10));
        top.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        top.add(statCard("Total Members", String.valueOf(store.getMembers().size())));
        top.add(statCard("Total Trainers", String.valueOf(store.getTrainers().size())));
        top.add(statCard("Today's Date", LocalDate.now().toString()));
        p.add(top, BorderLayout.NORTH);
        JTextArea notes = new JTextArea();
        notes.setEditable(false);
        notes.setText("Quick Reminders:\n");
        for (Member m : store.getMembers()) {
            if (m.getMembershipExpiry()!=null && m.getMembershipExpiry().isBefore(LocalDate.now().plusDays(7))) {
                notes.append("Membership expiring soon: " + m.getName() + " on " + m.getMembershipExpiry() + "\n");
            }
        }
        p.add(new JScrollPane(notes), BorderLayout.CENTER);
        return p;
    }

    private JPanel statCard(String title, String value) {
        JPanel p = new JPanel(new BorderLayout());
        // dark blue card with soft shadow-like border
        Color darkBlue = new Color(10, 30, 80);
        Color accent = new Color(58,123,213);
        p.setBackground(darkBlue);
        JLabel l1 = new JLabel(title); l1.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14)); l1.setForeground(Color.WHITE);
        JLabel l2 = new JLabel(value); l2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 26)); l2.setForeground(Color.WHITE);
        p.add(l1, BorderLayout.NORTH); p.add(l2, BorderLayout.CENTER);
    p.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(new Color(0,0,0,60)),
        BorderFactory.createMatteBorder(0,0,6,0, new Color(58,123,213))));
        return p;
    }

    // Members panel
    private JPanel createMembersPanel() {
        JPanel p = new JPanel(new BorderLayout());
        MemberTableModel model = new MemberTableModel(store.getMembers());
        JTable table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    JToolBar tb = new JToolBar(); tb.setFloatable(false);
    tb.setBackground(new Color(245,245,250));
    RoundedButton btnAdd = new RoundedButton("Add"); btnAdd.setBackground(new Color(160,220,255));
    RoundedButton btnEdit = new RoundedButton("Edit"); btnEdit.setBackground(new Color(160,220,255));
    RoundedButton btnDelete = new RoundedButton("Delete"); btnDelete.setBackground(new Color(255,180,180));
    tb.add(btnAdd); tb.addSeparator(new Dimension(8,0)); tb.add(btnEdit); tb.addSeparator(new Dimension(8,0)); tb.add(btnDelete);

        btnAdd.addActionListener(e -> {
            MemberDialog dlg = new MemberDialog(this, null);
            dlg.setVisible(true);
            if (dlg.isSucceeded()) {
                store.addMember(dlg.getMember());
                model.fireTableDataChanged();
            }
        });

        btnEdit.addActionListener(e -> {
            int sel = table.getSelectedRow();
            if (sel>=0) {
                Member m = store.getMembers().get(sel);
                MemberDialog dlg = new MemberDialog(this, m);
                dlg.setVisible(true);
                if (dlg.isSucceeded()) model.fireTableDataChanged();
            }
        });

        btnDelete.addActionListener(e -> {
            int sel = table.getSelectedRow();
            if (sel>=0) {
                Member m = store.getMembers().get(sel);
                if (JOptionPane.showConfirmDialog(this, "Delete " + m.getName() + "?","Confirm",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
                    store.removeMember(m); model.fireTableDataChanged();
                }
            }
        });

        p.add(tb, BorderLayout.NORTH);
        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    private JPanel createTrainersPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JTextArea ta = new JTextArea("Trainer management coming soon.\n\nYou can add trainers via code or extend UI.");
        ta.setEditable(false);
        p.add(ta, BorderLayout.CENTER);
        return p;
    }

    private JPanel createPaymentsPanel() {
        JPanel p = new JPanel(new BorderLayout());
        JTextArea ta = new JTextArea("Payments and billing coming soon.\n\nThis demo stores members and basic info.");
        ta.setEditable(false);
        p.add(ta, BorderLayout.CENTER);
        return p;
    }

    private static class MemberTableModel extends AbstractTableModel {
        private final String[] cols = {"ID","Name","Age","Weight","Height","BMI","Plan","Expiry"};
        private List<Member> members;
        public MemberTableModel(List<Member> members) { this.members = members; }
        public int getRowCount() { return members.size(); }
        public int getColumnCount() { return cols.length; }
        public String getColumnName(int c) { return cols[c]; }
        public Object getValueAt(int r, int c) {
            Member m = members.get(r);
            switch(c) {
                case 0: return m.getId().substring(0,6);
                case 1: return m.getName();
                case 2: return m.getAge();
                case 3: return m.getWeightKg();
                case 4: return m.getHeightCm();
                case 5: return String.format("%.1f", m.getBmi());
                case 6: return m.getPlan();
                case 7: return (m.getMembershipExpiry()==null?"-":m.getMembershipExpiry().toString());
                default: return "";
            }
        }
    }
}
