package pmlib.spec;

import org.junit.Test;
import pmlib.Movie;
import pmlib.MovieRepository;
import pmlib.command.AddCommand;
import pmlib.command.ListCommand;

import static org.junit.Assert.assertEquals;

public class ListCommandSpec {

    @Test
    public void listSingleMovieInLibrary() {
        MovieRepository library = new MovieRepository(new Movie[]{new Movie("Alien", 1979)});
        ListCommand command = new ListCommand(library, new String[] {"list"});
        assertEquals("Alien (1979)", command.call());
    }
    @Test
    public void listMoviesInLibrary() {
        MovieRepository library = new MovieRepository(new Movie[]{new Movie("Alien", 1979), new Movie("Aliens", 1986)});
        ListCommand command = new ListCommand(library, new String[] {"list"});
        assertEquals("Alien (1979)\nAliens (1986)", command.call());
    }
}
