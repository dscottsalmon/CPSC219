
public class Movie {

private String title;
private int rating;

public Movie(String newTitle, int newRating) {
	this.setTitle(newTitle.toUpperCase());
	
	if (newRating > -1 && newRating <11) {
		this.rating = newRating;
	}
}
public Movie(Movie other) {
	this.setTitle(other.getTitle());
	this.rating = other.rating;
}

public String getTitle() {
	return this.title;
}

public void setTitle(String newTitle) {
	this.title = newTitle.toUpperCase();
}

public void setRating(int newRating) {
	if (newRating > -1 && newRating < 11) {
		this.rating = newRating;
	}
}

public int getRating() {
	return this.rating;
	}

public char getCategory() {
	char Grade;
	if (rating < 3) {
		Grade = 'F';
	} else if (rating < 5) {
		Grade = 'D';
	} else if (rating < 7) {
		Grade = 'C';
	} else if (rating < 9) {
		Grade = 'B';
	} else {
		Grade = 'A';
	}
	return Grade;
	}

}

