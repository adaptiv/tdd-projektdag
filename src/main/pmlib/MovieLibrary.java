package pmlib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieLibrary {
    private List movies = new ArrayList();

    public MovieLibrary() {
    }

    public MovieLibrary(Movie[] movies) {
        this.movies = new ArrayList<Movie>(Arrays.asList(movies));
    }

    public List getMovies() {
        return movies;
    }

    public void setMovies(List movies) {
        this.movies = movies;
    }
}
