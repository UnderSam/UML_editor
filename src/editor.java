import java.awt.EventQueue;

public class editor {
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI.getInstance().initialize();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
