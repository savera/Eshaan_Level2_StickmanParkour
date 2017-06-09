
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	final int INSTRUCT_STATE = 3;
	int currentState = MENU_STATE;
	Timer timer;
	Font titleFont;
	Font titleFont2;
	Stickman stickman;
	JButton button;
	//Falling_Blocks blocks;
    ObjectManager manager = new ObjectManager();
	// public static BufferedImage alienImg;
	public static BufferedImage main2Img;
	//public static BufferedImage FallingBImg;
	// public static BufferedImage fallingImg;

	// public static BufferedImage bulletImg;
	GamePanel() {
		Random random = new Random();
		stickman = new Stickman(200, 860, 30, 30);
		manager.addObject(stickman);
		//blocks = new Falling_Blocks(250, 100, 35, 35);
		titleFont = new Font("Lucida Calligraphy", Font.PLAIN, 54);
		titleFont2 = new Font("Lucida Calligraphy", Font.PLAIN, 30);
//        for (int i = 0; i < 100; i++) {
//			manager.addObject(new Falling_Blocks(random.nextInt(1000) , 100, 35,35));
//		}
		try {
			main2Img = ImageIO.read(this.getClass().getResourceAsStream("Main2.jpg"));
		//	FallingBImg = ImageIO.read(this.getClass().getResourceAsStream("FallingBlocks.jpg"));
			// fallingImg =
			// ImageIO.read(this.getClass().getResourceAsStream("falling.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer = new Timer(1000 / 60, this);
		
	}

	void startGame() {
	
		timer.start();
	
	}

	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
		}
		if (currentState == GAME_STATE) {
			drawGameState(g);
		}
		if (currentState == END_STATE) {
			drawEndState(g);
		}
		if (currentState == INSTRUCT_STATE) {
			drawInstructState(g);
		}
	}

	void drawMenuState(Graphics g) {
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 500, 900);

		//g.setFont(titleFont);
		//g.setColor(Color.MAGENTA);
		//g.drawString("Falling Sky", 290, 200);
		if(button == null){
		startButton();
		}
		
		g.setFont(titleFont2);
		g.setColor(Color.ORANGE);
		//g.drawString("Click on Start to play the game", 350, 300);

		g.setFont(titleFont2);
		g.setColor(Color.MAGENTA);
		//g.drawString("Click Instructions for How To Play", 300, 400);

	}
void startButton(){
	button = new JButton();
	
    add(button);
	button.setVisible(true);
	button.setSize(100, 100);
	button.setBackground(Color.WHITE);
	button.setText("Start");
   // button.setForeground(Color.WHITE);
    button.setOpaque(true);
}
	void drawGameState(Graphics g) {
		if(button!=null){
		remove(button);
			button = null;
		}
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 500, 900);
		stickman.draw(g);
		//blocks.draw(g);
		manager.draw(g);
	}

	void drawEndState(Graphics g) {
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, 500, 900);

		//g.setFont(titleFont);
		//g.setColor(Color.RED);
		//g.drawString("GAME OVER", 360, 225);

	//	g.setFont(titleFont2);
		//g.setColor(Color.RED);
		//g.drawString("Press BACKSPACE to Restart", 330, 415);

		g.setFont(titleFont2);
		g.setColor(Color.BLACK);

	}

	void drawInstructState(Graphics g) {
//		g.setColor(Color.BLACK);
//		g.fillRect(0, 0, 500, 900);

	//	g.setFont(titleFont);
		//g.setColor(Color.WHITE);
		//g.drawString("How to Play", 40, 90);

		//g.setFont(titleFont2);
		//("Press the Up Arrow Key to go RIGHT", 40, 150);
		//g.drawString("Press the Left Key to go LEFT", 40, 210);
		//("Press Up Arrow Key to JUMP", 40, 270);
	}

	void updateMenuState() {

	}

	void updateGameState() {
		//
		//stickman.update();
		//blocks.update();
		manager.checkCollision();
		manager.update();
		manager.manageEnemies();
	}

	void updateEndState() {

	}

	void updateInstructState() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
		if (currentState == INSTRUCT_STATE) {
			updateInstructState();
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyTyped");

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyPressed");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			currentState = INSTRUCT_STATE;

		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			stickman.rightKey = true;

		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			stickman.leftKey = true;
		}
//		 else if (e.getKeyCode() == KeyEvent.VK_UP) {
//			stickman.upkey = true;
//		}

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			currentState = MENU_STATE;
		}
		updateGameState();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("keyReleased");
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			stickman.leftKey = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			stickman.rightKey = false;

		}
//		if (e.getKeyCode() == KeyEvent.VK_UP) {
//			stickman.upkey = false;
//		}

	}

}