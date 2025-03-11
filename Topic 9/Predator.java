
public class Predator extends Animal{

private String huntStyle = "stalk";

Predator(char type, int health, String newHuntStyle){
	super(type, health);
	if (newHuntStyle == "stalk" || newHuntStyle == "ambush") {
		this.huntStyle = newHuntStyle;
		}else{
		this.huntStyle = "stalk";
	}
}
Predator(Predator toCopy){
	super(toCopy);
	setHuntStyle(toCopy.getHuntStyle()); 
}

public String getHuntStyle() {
	return this.huntStyle;
	}
public void setHuntStyle(String newHuntStyle) {
	if (newHuntStyle == "stalk" || newHuntStyle == "ambush") {
		this.huntStyle = newHuntStyle;
		}
}
public double getRelativeHealth() {
	float x;
	if (huntStyle == "ambush") {
		x = ((getHealth() * 0.75f));
		} else {
		x = ((getHealth() * 1.5f));
		}
	return x;
	}

public String toString() {
	String x = "[Predator] " + super.toString() + " Hunt style: " + huntStyle;
	return x;
	}
}
