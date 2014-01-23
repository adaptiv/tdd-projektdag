package pmlib.spec;

import org.junit.Test;
import pmlib.Movie;
import pmlib.MovieLibrary;
import pmlib.MovieRepository;
import pmlib.command.AddCommand;
import pmlib.command.ListCommand;

import static org.junit.Assert.assertEquals;

public class ListCommandSpec {

    @Test
    public void listSingleMovieInLibrary() {
        MovieLibrary library = new MovieLibrary(new Movie[]{new Movie("Alien", 1979)});
        ListCommand command = new ListCommand(library, new String[] {"list"});
        assertEquals("Alien (1979)", command.call());
    }
    @Test
    public void listMoviesInLibrary() {
        MovieLibrary library = new MovieLibrary(new Movie[]{new Movie("Alien", 1979), new Movie("Aliens", 1986)});
        ListCommand command = new ListCommand(library, new String[] {"list"});
        assertEquals("Alien (1979)\nAliens (1986)", command.call());
    }
}
