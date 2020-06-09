import java.awt.EventQueue;

import javax.swing.JFrame;

public class editor {

	private int Mode;
	private JFrame frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					editor window = new editor();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public editor() {
		this.setMode(0);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 984, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GUI myGUI = new GUI(this);
		myGUI.initialize();
	}

	public int getMode() {
		return Mode;
	}

	public void setMode(int mode) {
		Mode = mode;
	}
	public JFrame getFrame() {
		return frame;
	}
}
