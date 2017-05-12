import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GameObject {
	GameObject(){
		collisionBox.setBounds(x, y, width, height);
		
	}
	int x;
	int y;
	int width;
	int height;
	int lane;
	public boolean isAlive;
	 Rectangle collisionBox = new Rectangle();
	 Rectangle collisionBox2 = new Rectangle();
	 Rectangle collisionBox3 = new Rectangle();
	 Rectangle collisionBox4 = new Rectangle();
	void update() {
		collisionBox.setBounds(x, y, width, height);
		collisionBox2.setBounds(x + 5, y, width -10 , height - 25);
		collisionBox3.setBounds(x + 25, y , width - 20, height );
		collisionBox4.setBounds(x -5 , y, width - 25, height);
		
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		
		g.fillRect(x, y, width,height);	
	}
}
