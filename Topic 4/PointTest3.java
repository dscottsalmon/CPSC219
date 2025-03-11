import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest3 {
	
	@Test
	public void test_Constructor_Point0_0() {
		Point p = new Point(0,0);
		assertEquals("Created Point(0,0) - testing x value", 0, p.xcoord);
		assertEquals("Created Point(0,0) - testing y value", 0, p.ycoord);
	}

	@Test
	public void test_Constructor_NegativeX() {
		Point p = new Point(-1,10);
		assertEquals("Created Point(-1,10) - testing x value", 0, p.xcoord);
		assertEquals("Created Point(-1,10) - testing y value", 10, p.ycoord);
	}

	@Test
	public void test_Constructor_NegativeY() {
		Point p = new Point(5,-4);
		assertEquals("Created Point(5,-4) - testing x value", 5, p.xcoord);
		assertEquals("Created Point(5,4) - testing y value", 0, p.ycoord);
	}

	@Test
	public void test_Constructor_NegativeXandY() {
		Point p = new Point(-2,-11);
		assertEquals("Created Point(-2,-11) - testing x value", 0, p.xcoord);
		assertEquals("Created Point(-2,-11) - testing y value", 0, p.ycoord);
	}

	@Test
	public void test_Constructor_PositiveXandY() {
		Point p = new Point(5,7);
		assertEquals("Created Point(5,7) - testing x value", 5, p.xcoord);
		assertEquals("Created Point(5,7) - testing y value", 7, p.ycoord);
	}

	@Test
	public void test_CopyConstructor() {
		Point p = new Point(5,7);
		Point p2 = new Point(p);
		assertEquals("Created Point(5,7) and copied it.  Testing x value of original.", 5, p.xcoord);
		assertEquals("Created Point(5,7) and copied it.  Testing y value of original.", 7, p.ycoord);
		assertEquals("Created Point(5,7) and copied it.  Testing x value of copy.", 5, p2.xcoord);
		assertEquals("Created Point(5,7) and copied it.  Testing y value of copy.", 7, p2.ycoord);
	}



	@Test
	public void test_moveUp() {
		Point p = new Point();
		p.moveUp(3);
		assertEquals("Created Point (0,0) then moved up 3 - testing x value", 0, p.xcoord);
		assertEquals("Created Point (0,0) then moved up 3 - testing y value", -3, p.ycoord);
	}

	@Test
	public void test_moveDown() {
		Point p = new Point();
		p.moveDown(5);
		assertEquals("Created Point (0,0) then moved down 5 - testing x value", 0, p.xcoord);
		assertEquals("Created Point (0,0) then moved down 5 - testing y value", 5, p.ycoord);
	}

	@Test
	public void test_moveLeft() {
		Point p = new Point();
		p.moveLeft(1);
		assertEquals("Created Point (0,0) then moved left 1 - testing x value", -1, p.xcoord);
		assertEquals("Created Point (0,0) then moved left 1 - testing y value", 0, p.ycoord);
	}

	@Test
	public void test_moveRight() {
		Point p = new Point();
		p.moveRight(101);
		assertEquals("Created Point (0,0) then moved right 101- testing x value", 101, p.xcoord);
		assertEquals("Created Point (0,0) then moved right 101 - testing y value", 0, p.ycoord);
	}
	
	@Test
	public void test_distance_StartIsTopLeft_EndIsBottomRight() {
		Point p1 = new Point();
		p1.xcoord = 1;
		p1.ycoord = 2;
		Point p2 = new Point();
		p2.xcoord = 4;
		p2.ycoord = 6;
		double length = p1.distance(p2);
		
		assertEquals("Distance from point (1,2) to (4,6) should be 5.0", 5.0, length, 0.00001);
	}

	@Test
	public void test_distance_StartIsTopRight_EndIsBottomLeft() {
		Point p1 = new Point();
		p1.xcoord = 10;
		p1.ycoord = 2;
		
		Point p2 =  new Point();
		p2.xcoord = 4;
		p2.ycoord = 6;
		
		double length = p1.distance(p2);
		
		assertEquals("Distance from point (10,2) to (4,6) should be 7.21110", 7.21110, length, 0.00001);
	}

	@Test
	public void test_distance_StartIsBottomRight_EndIsTopLeft() {
		Point p1 = new Point();
		p1.xcoord = 10;
		p1.ycoord = 20;
		Point p2 = new Point();
		p2.xcoord = 4;
		p2.ycoord = 6;
		double length = p1.distance(p2);
		
		assertEquals("Distance from point (10,20) to (4,6) should be 15.2315462", 15.2315462, length, 0.00001);
	}

	@Test
	public void test_distance_StartIsBottomLeft_EndIsTopRight() {
		Point p1 = new Point();
		p1.xcoord = 2;
		p1.ycoord = 20;
		
		Point p2 = new Point();
		p2.xcoord = 4;
		p2.ycoord = 6;
		double length = p1.distance(p2);
		
		assertEquals("Distance from point (2,20) to (4,6) should be 14.142135", 14.142135, length, 0.00001);
	}
	
	@Test
	public void test_equals_SameInstance() {
		Point p1 = new Point();
		p1.xcoord = 2;
		p1.ycoord = 20;
		
		Point p2 = p1;
		boolean same = p1.equals(p2);
		
		assertTrue("Expected variables that reference same object to be equal", same);
	}
	
	@Test
	public void test_equals_SameXAndY() {
		Point p1 = new Point();
		p1.xcoord = 2;
		p1.ycoord = 20;

		Point p2 = new Point();
		p2.xcoord = 2;
		p2.ycoord = 20;
		
		boolean same = p1.equals(p2);
		
		assertTrue("Expected variables that have the same x and y-coordinate to be equal", same);
	}
	
	@Test
	public void test_equals_DifferentX() {
		Point p1 = new Point();
		p1.xcoord = 2;
		p1.ycoord = 20;

		Point p2 = new Point();
		p2.xcoord = 3;
		p2.ycoord = 20;

		boolean same = p1.equals(p2);
		
		assertFalse("Expected variables with different x-coordinates to be unequal", same);
	}
	
	@Test
	public void test_equals_DifferentY() {
		Point p1 = new Point();
		p1.xcoord = 2;
		p1.ycoord = 20;

		Point p2 = new Point();
		p2.xcoord = 2;
		p2.ycoord = 0;

		boolean same = p1.equals(p2);
		
		assertFalse("Expected variables with different y-coordinates to be unequal", same);
	}
	
	@Test
	public void test_toString1() {
		Point p1 = new Point();
		p1.xcoord = 2;
		p1.ycoord = 20;
		assertEquals("Created point (2,20)", "(2,20)", p1.toString());
	}
	
	@Test
	public void test_toString2() {
		Point p1 = new Point();
		p1.xcoord = 5;
		p1.ycoord = 7;
		assertEquals("Created point (5,7)", "(5,7)", p1.toString());
	}	
}
