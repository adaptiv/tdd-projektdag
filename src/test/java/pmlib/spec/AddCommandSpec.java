package pmlib.spec;

import org.junit.Test;
import pmlib.Movie;
import pmlib.MovieLibrary;
import pmlib.MovieRepository;
import pmlib.command.AddCommand;

import static org.junit.Assert.assertEquals;

public class AddCommandSpec {

    @Test
    public void addMovieToLibrary() {
        MovieLibrary library = new MovieLibrary();
        new AddCommand(library, new String[] {"add", "Alien", "1979"}).call();
        assertEquals(1, library.getMovies().size());
    }

    @Test
    public void addDuplicateMovieToLibrary() {
        MovieLibrary library = new MovieLibrary(new Movie[]{new Movie("Alien", 1979)});
        String result = new AddCommand(library, new String[] {"add", "Alien", "1979"}).call();
        assertEquals("Already exists: Alien (1979)", result);
    }
}
