import java.awt.Color;
import java.awt.Graphics;
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
	void update() {
		collisionBox.setBounds(x, y, width, height);
	}

	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.fillRect(x, y, width,height);	
	}
}
