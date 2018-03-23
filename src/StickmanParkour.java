  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class StickmanParkour extends JPanel implements ActionListener, KeyListener {
	
	GamePanel panel;
	JFrame frame;
	int width = 490;
	int height = 920;

	StickmanParkour() {
		panel = new GamePanel();
		frame = new JFrame();
		setup();
	}

	public static void main(String[] args) {
		new StickmanParkour();
	}

	void setup() {
		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(width, height);
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.startGame();

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
