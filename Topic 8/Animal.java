
public class Animal {

private char type = 'n';
private int age = 0;
private int health = 50;

public Animal(char newType, int newAge, int newHealth) {
	
	if (newType == 'm' || newType == 'b' || newType == 'f' || newType == 'r'|| newType == 'a' || newType == 'n') {
			type = newType;	//this sets the type
		
		if ( (type == 'm' || type =='r') && (newAge >=0 && newAge <=100)) {	
			this.age = newAge;
				}
		if ( (type == 'b' || type =='f' || type == 'a') && (newAge >=0 && newAge <=10)) {	
			this.age = newAge;
				}
		if (type == 'n' && (newAge >=0 && newAge <=2)) { 
			this.age = newAge;
				}
		}
		if(newHealth > 0) {
			this.health = newHealth;
			}
		
		}
	
public Animal(Animal toCopy) {
	this.type = toCopy.getType();
	this.age = toCopy.getAge();
	this.health = toCopy.getHealth();
	Animal copiedAnimal = new Animal(type, age, health);
		}

public char getType() {
	return this.type;
		}

public void setType(char newType) {
	if ((newType == 'm' || newType == 'b' || newType == 'f' || newType == 'r'|| newType == 'a' || newType == 'n')) {
		this.type = newType;
			}
		}

public int getAge() {
	return this.age;
		}

public void setAge(int newAge) {
	if (newAge >=0) {
		if ( (type == 'm' || type =='r') && (newAge >=0 && newAge <=100)) {	
			this.age = newAge;
				}
		if ( (type == 'b' || type =='f' || type == 'a') && (newAge >=0 && newAge <=10)) {	
			this.age = newAge;
				}
		if (type == 'n' && (newAge >=0 && newAge <=2)) { 
			this.age = newAge;
				}
		}
	}

public int getHealth() {
	return this.health;
	}

public void setHealth(int amount) {
	if(amount > 0) {
		this.health = amount;
		}
	}

public double getRelativeHealth() {
	return (health/(101.0-age));
	}

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
