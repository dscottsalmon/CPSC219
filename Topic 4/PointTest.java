import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

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
