public class Line {
	private Point start;
	private Point end;
	
	public Line(Point aStart, Point anEnd){
		start = aStart;
		end = anEnd;
	}
	public String toString() {
		return "From: " + start + " To: " + end;
	}
	public void moveDown(int amount) {
		start.moveDown(amount);
		end.moveDown(amount);
	}
	public double length() {
		return start.distance(end);
	}
	public static void main(String[] args) {
		Point p1 = new Point(1,2);
		Point p2 = new Point(4,5);
		Line l1 = new Line(p1,p2);
		Line l2 = new Line(p1,p2);
		
		System.out.println("Line 1: " + l1);
		System.out.println("Line 2: " + l2);
		
		l1.moveDown(10);

		System.out.println("Line 1: " + l1);
		System.out.println("Line 2: " + l2);
	}	

}
