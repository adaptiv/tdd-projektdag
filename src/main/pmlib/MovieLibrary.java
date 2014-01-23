package pmlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieLibrary {
    private List<Movie> movies = new ArrayList<Movie>();

    public MovieLibrary() {
    }

    public MovieLibrary(Movie[] movies) {
        this.movies = new ArrayList<Movie>(Arrays.asList(movies));
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
