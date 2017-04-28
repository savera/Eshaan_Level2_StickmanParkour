
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	static int[] lanes = { 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865, 865};


	public int getLanes(int i) {
		return lanes[i];
	}

	public void setLanes(int lane, int h) {
		lanes[lane] = h;
	}

	public ObjectManager() {
		objects = new ArrayList<GameObject>();
	}

	public void addObject(GameObject o) {
		objects.add(o);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}

		// purgeObjects();
	}

	public void draw(Graphics g) {
		
		for (int i = 0; i < objects.size(); i++) {
			GameObject o =objects.get(i);
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

	public void manageEnemies() {
		int enemyLane = new Random().nextInt(Stickman_Parkour.width) / 35;
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addObject(new Falling_Blocks(enemyLane * 35, 0, 35, 35, enemyLane));
			enemyTimer = System.currentTimeMillis();
		}

	}
	
	 public void checkCollision() {
	 for (int i = 0; i < objects.size(); i++) {
	 for (int j = i + 1; j < objects.size(); j++) {
	 GameObject o1 = objects.get(i);
	 GameObject o2 = objects.get(j);
	 if(o1 instanceof Stickman){
		 //System.out.println(o1.collisionBox);
	 }
	 if(o1.collisionBox.intersects(o2.collisionBox)){
	 if((o1 instanceof Falling_Blocks && o2 instanceof Stickman) ||
	 (o2 instanceof Falling_Blocks && o1 instanceof Stickman)){
		 System.out.println("collision");
		System.out.println(o2.y);
	 }
	 else if(o1 instanceof Stickman) {
		 System.out.println("collision");
	 }
	
	 }
	 }
	 }
	 }

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
	}
}
