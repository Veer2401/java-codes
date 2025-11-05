package Gym_App;

public class GymApp {
	public static void main(String[] args) {
		// Launch the Swing UI on the Event Dispatch Thread
		javax.swing.SwingUtilities.invokeLater(() -> {
			// Show login dialog and then main frame
			LoginDialog login = new LoginDialog(null);
			login.setVisible(true);
			if (login.isSucceeded()) {
				String role = login.getRole();
				MainFrame frame = new MainFrame(role);
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			} else {
				// exit if login cancelled
				System.exit(0);
			}
		});
	}
}
