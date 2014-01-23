package pmlib.spec;

import org.junit.Test;
import pmlib.Movie;
import pmlib.MovieLibrary;
import pmlib.command.LendCommand;

import static org.junit.Assert.assertTrue;

public class LendCommandSpec {

    @Test
    public void movieShouldBeLendable() {
        Movie alien = new Movie("Alien", 1979);
        MovieLibrary library = new MovieLibrary(new Movie[] {alien});
        new LendCommand(library, new String[] {"lend", "Alien"}).call();
        assertTrue(alien.isLoaned());
    }
}
