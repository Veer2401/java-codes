package Gym_App;

import javax.swing.*;
import java.awt.*;

/**
 * Simple rounded button with custom background painting.
 */
public class RoundedButton extends JButton {
    private int radius = 24;

    public RoundedButton(String text) {
        super(text);
        init();
    }

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        init();
    }

    private void init() {
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(false);
        setForeground(Color.BLACK);
        setPreferredSize(new Dimension(120, 40));
        setFont(getFont().deriveFont(Font.BOLD, 13f));
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // background
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        // draw text
        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    public void paintBorder(Graphics g) {
        // optional subtle border
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground().darker());
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
        g2.dispose();
    }

    @Override
    public boolean isOpaque() {
        return false;
    }
}
