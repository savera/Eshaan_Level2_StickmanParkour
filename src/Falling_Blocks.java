import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Falling_Blocks extends GameObject{
	boolean left = true;
Falling_Blocks(int x, int y, int width, int height){
	super();
	this.x = x;
	this.y = y;
	this.height = height;
	this.width = width;
}
void update(){
	super.update();
	y++;

	 if(x <= 0){
		left = false;
	 }
	if(x>= 500 - width){
		left = true;
	}

	 
	  if(left){
		 x = x-new Random().nextInt(5);

	 }
	  else {
			 x = x+new Random().nextInt(5);

	  }
}
void draw(Graphics g){
	g.setColor(Color.black);
g.fillRect(x, y, width, height);
}
}
