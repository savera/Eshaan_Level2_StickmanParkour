
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;
	
	private int score = 0;
	
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	
	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			Falling_Blocks o = (Falling_Blocks) objects.get(i);
			o.update();
		}
		
		//purgeObjects();	
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			Falling_Blocks o = (Falling_Blocks) objects.get(i);
			o.draw(g);
		}
	}

	private void purgeObjects() {
		for (int i = 0; i < objects.size(); i++) {
			if (!objects.get(i).isAlive) {
				objects.remove(i);
			}
		}
	}

	public void manageEnemies(){
		int enemyLane = new Random().nextInt(Stickman_Parkour.width) / 35;
		if(System.currentTimeMillis() - enemyTimer >= enemySpawnTime){
			addObject(new Falling_Blocks(enemyLane * 35, 0, 35, 35, enemyLane));
			enemyTimer = System.currentTimeMillis();
		}
	}
//
//	public void checkCollision() {
//		for (int i = 0; i < objects.size(); i++) {
//			for (int j = i + 1; j < objects.size(); j++) {
//				GameObject o1 = objects.get(i);
//				GameObject o2 = objects.get(j);
//				
//				if(o1.collisionBox.intersects(o2.collisionBox)){
//					if((o1 instanceof Aliens && o2 instanceof Projectile) ||
//					   (o2 instanceof Aliens && o1 instanceof Projectile)){
//						score++;
//						System.out.println(score);
//						o1.isAlive = false;
//						o2.isAlive = false;
//					}
//					else if((o1 instanceof Aliens && o2 instanceof Rocketship) ||
//							(o2 instanceof Aliens && o1 instanceof Rocketship)){
//						o1.isAlive = false;
//						o2.isAlive = false;
//					}
//
//			}
//			}
//		}
//	}
	
	public int getScore(){
		return score;
	}
	
	public void setScore(int s){
		score = s;
	}
	
	public void reset(){
		objects.clear();
	}
}
