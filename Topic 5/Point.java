public class Point {
    private int xcoord = 0;
    private int ycoord = 0;
    
    public Point(Point toCopy){
    	xcoord = toCopy.xcoord;
    	ycoord = toCopy.ycoord;
    }
    public Point(int x, int y){
    	setXCoord(x);
    	setYCoord(y);
    }
    public void moveDown(int amount) {
    	// to go down we need to go further away from 0
        setYCoord(ycoord + amount);
    }
    public String toString() {
    	return "(" + xcoord + "," + ycoord + ")";
    }
    
    public void moveUp(int amount) {
    	//To go up on the screen, we need to get closer to zero: we must subtract
        setYCoord(ycoord - amount);
    }
    
    public void moveRight(int amount) {
        setXCoord(xcoord + amount);
    }
    
    public void moveLeft(int amount) {
        setXCoord(xcoord - amount);
    }

    public int getXCoord() {
        return xcoord;
    }
    
    public int getYCoord() {
        return ycoord;
    }
    
    public void setXCoord(int xValue) {
    	if (xValue >= 0) {
            xcoord = xValue;
    	}
    }
    
    public void setYCoord(int yValue) {
    	if (yValue >= 0) {
            ycoord = yValue;
    	}
    }

    public double distance(Point other) {
        int xdiff = xcoord - other.xcoord;
        int ydiff = ycoord - other.ycoord;
        int xsquare = xdiff * xdiff;
        int ysquare = ydiff * ydiff;
        double distance = Math.sqrt(xsquare + ysquare);
        return distance;
    }
    
    public boolean equals(Point other) {
        return xcoord == other.xcoord && ycoord == other.ycoord;
    }
}