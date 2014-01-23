package pmlib.spec;

import org.junit.Test;
import pmlib.Movie;
import pmlib.MovieLibrary;
import pmlib.MovieRepository;
import pmlib.command.CountCommand;

import static org.junit.Assert.assertEquals;

public class CountCommandSpec {
    @Test
    public void noMoviesExistInAnEmptyMovieLibrary() {
        CountCommand count = new CountCommand(new MovieLibrary(), new String[]{});
        assertEquals("0", count.call());
    }

    @Test
    public void returnsNumberOfMoviesInAPopulatedMovieLibrary() {
        CountCommand count = new CountCommand(new MovieLibrary(new Movie[] {
                new Movie(),
                new Movie(),
                new Movie()
        }), new String[] {});
        assertEquals("3", count.call());
    }
}
