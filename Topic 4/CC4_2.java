
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
	
	double distance(Point other) {
		double A = (this.xcoord - other.xcoord);
		double B = (this.ycoord - other.ycoord);
		double C = Math.sqrt( (A*A) + (B*B) );
		return C;
	}
	
	boolean equals(Point other) {
		return (this.xcoord == other.xcoord) && (this.ycoord == other.ycoord);
	}
}
