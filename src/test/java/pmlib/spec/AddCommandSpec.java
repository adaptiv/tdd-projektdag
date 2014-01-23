package pmlib.spec;

import org.junit.Test;
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
}
