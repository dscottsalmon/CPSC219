import java.util.ArrayList;
import java.util.Collections;

public class Festival {

private String name;
private ArrayList<Movie> movieList = new ArrayList<Movie>();	

public Festival(String other) {
	this.setName(other);
}

public String getName() {
	return this.name;
}

public void setName(String name) {
	this.name = name;
}

public ArrayList<Movie> getMovieList() {
	
	int x = 0;
	ArrayList<Movie> newList = new ArrayList<Movie>();
	
	while (x < movieList.size()) {
	Movie m1 = new Movie(movieList.get(x));
	newList.add(m1);
	x++;
	}

	return newList;
}

public void setMovieList(ArrayList<Movie> movieList) {
	this.movieList = movieList;
}

public void addMovie(Movie OgMovie) {
	Movie newMovie = new Movie(OgMovie);
	movieList.add(newMovie);
	}

public Movie getMovieWithLowestRating() {
	
	ArrayList<Integer> ratingList = new ArrayList<Integer>();
	int x = 0;
	while (x < (getMovieList().size())) {
		Movie m1 = getMovieList().get(x);
		ratingList.add(m1.getRating());
		x++;
		}
	
//	System.out.println(ratingList);

	if (ratingList.size() == 0) {
		return null;
	} else {
		int min = Collections.min(ratingList);
		int index = ratingList.indexOf(min);
		return new Movie(getMovieList().get(index));
		}


	}


}
