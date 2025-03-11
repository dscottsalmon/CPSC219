
public abstract class Animal {

private char type = 'n';
private int health = 50;

public Animal(char newType, int newHealth) {
	
	if (newType == 'm' || newType == 'b' || newType == 'f' || newType == 'r'|| newType == 'a' || newType == 'n') {
			type = newType;	//this sets the type
			}
	if(newHealth > 0) {
			this.health = newHealth;
			}
		}
	
public Animal(Animal toCopy) {
	this.type = toCopy.getType();
	this.health = toCopy.getHealth();
//	Animal copiedAnimal = new Animal(type, health);
		}


public char getType() {
	return this.type;
		}

protected void setType(char newType) {
	if ((newType == 'm' || newType == 'b' || newType == 'f' || newType == 'r'|| newType == 'a' || newType == 'n')) {
		this.type = newType;
			} else {
		this.type = 'n';
			}
		}

public int getHealth() {
	return this.health;
	}

public void setHealth(int amount) {
	if(amount > 0) {
		this.health = amount;
		} else {
		this.health = 50;
		}
	}

public String toString() {
	return "Type: " + type + " Health: " + getRelativeHealth() ;
}
public abstract double getRelativeHealth();

public String getStatus() {
	String status = null;
	if (getRelativeHealth() < 25) {
			status = "critical";
		} else if (getRelativeHealth() < 50) {
			status = "tenuous";
		} else if (getRelativeHealth() < 75) {
			status = "good";
		} else {
			status = "excellent";
		}
	return status;
	}


}
