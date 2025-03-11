
public class Prey extends Animal {

	private String defence = "stampede";
	private int herdsize = 1;
	
	Prey(char type, int health, String newDefence) {
		super(type, 0, health);
		setDefence(newDefence);
	}
	
	Prey(Prey toCopy){
		super(toCopy);
		setDefence(toCopy.getDefence());
	}
	
	public String getDefence() {
		return this.defence;
	}
	
	public void setDefence(String newDefence) {
		if (newDefence.equals("stampede") || newDefence.equals("huddle") || newDefence.equals("hide")) {
			this.defence = newDefence;
		}
		
	}
	
	public int getHerdSize() {
		return this.herdsize;
	}
	
	public void setHerdSize(int size) {
		if (size>=1) {
			herdsize=size;
		}
	}
	
	public double getRelativeHealth() {
		double value;
		if (defence.equals("hide")) {
			value = super.getHealth();
		} else {
			value = (getHealth() * (herdsize/10.0));
			}
		return value;
	}
}
