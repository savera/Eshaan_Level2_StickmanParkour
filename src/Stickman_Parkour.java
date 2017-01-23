import java.awt.Panel;

import javax.swing.JFrame;

public class Stickman_Parkour {
	GamePanel panel;

	JFrame frame;
	static int width = 1000;
	int height = 800;

	Stickman_Parkour() {
		panel = new GamePanel();
		frame = new JFrame();
		setup();
	}
	public static void main(String[] args) {
		  new Stickman_Parkour();
		
		
		
	}
	void setup() {
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setVisible(true);
		frame.setSize(width, height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();

	}
}
