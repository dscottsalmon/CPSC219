
public class Point {

	int xcoord;
	int ycoord;
	
	void moveUp(int amount){
		ycoord -= amount;
	}
	
	void moveDown(int amount) {
		ycoord +=amount;
	}
	
	void moveRight(int amount){
		xcoord += amount;
	}
	
	void moveLeft(int amount) {
		xcoord -=amount;
	}
	
	public String toString() {
		return "(" + xcoord + "," + ycoord + ")";
	}
	
}
