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

    public void add(Movie movie) throws DuplicateMovieException {
        if (movies.contains(movie)) {
            throw new DuplicateMovieException();
        }
        movies.add(movie);
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equals(title)) {
                return movie;
            }
        }
        return null;
    }

    public void lend(Movie movie) {
        movie.setLoaned(true);
    }
}
